package org.deanlee.course.networkio.noblockingio;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.util.logging.Logger;

/**
 * @author LiMeng
 * @version 1.0
 * @date 2019-11-21 20:57
 * 同步非阻塞-多路复用实现 channel demo
 */
public class NioSendDemo {
    private Charset charset = Charset.forName("UTF-8");

    public static void main(String[] args) throws Exception {
        // 启动客户端连接
        NioSendDemo client = new NioSendDemo();
        // 传输文件
        client.sendFile(new File("").getAbsolutePath() + "/course-io/src/main/resources/test.txt");

    }

    /**
     * 向服务器端传输文件
     */
    public void sendFile(String filePath) throws Exception {
        try {

            File file = new File(filePath);
            if (!file.exists()) {
                Logger.getLogger(NioSendDemo.class.getName()).info("文件不存在");
                return;
            }
            FileChannel fileChannel = new FileInputStream(file).getChannel();
            SocketChannel socketChannel = SocketChannel.open();
            socketChannel.socket().connect(new InetSocketAddress("127.0.0.1", 8081));
            socketChannel.configureBlocking(false);
            while (!socketChannel.finishConnect()) {
                //不断地自旋、等待，或者做一些其他的事情
            }
            Logger.getLogger(NioSendDemo.class.getName()).info("Client成功连接服务器端");
            //发送文件名称
            ByteBuffer fileNameByteBuffer = charset.encode("testChannel.txt");
            socketChannel.write(fileNameByteBuffer);
            //发送文件长度
            ByteBuffer buffer = ByteBuffer.allocate(16);
            buffer.putLong(file.length());
            buffer.flip();
            socketChannel.write(buffer);
            buffer.clear();
            //发送文件内容
            Logger.getLogger(NioSendDemo.class.getName()).info("开始传输文件");
            int length = 0;
            long progress = 0;
            while ((length = fileChannel.read(buffer)) > 0) {
                buffer.flip();
                socketChannel.write(buffer);
                buffer.clear();
                progress += length;
                Logger.getLogger(NioSendDemo.class.getName()).info("| " + (100 * progress / file.length()) + "% |");
            }
            if (length == -1) {
                fileChannel.close();
                //在SocketChannel传输通道关闭前，尽量发送一个输出结束标志到对端
                socketChannel.shutdownOutput();
                socketChannel.close();
            }
            Logger.getLogger(NioSendDemo.class.getName()).info("======== 文件传输成功 ========");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
