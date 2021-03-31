package org.deanlee.course.networkio.noblockingio.reactor;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.util.logging.Logger;

/**
 * @author LiMeng
 * @version 1.0
 * @date 2019-11-21 20:57
 * 同步非阻塞-多路复用实现 channel demo
 */
public class SingleReactorSendDemo {
    private Charset charset = Charset.forName("UTF-8");

    public static void main(String[] args) throws Exception {
        // 启动客户端连接
        SingleReactorSendDemo client = new SingleReactorSendDemo();
        // 传输文件
        client.sendFile("Hello NIO World,Server!!!");

    }

    /**
     * 向服务器端传输数据
     */
    public void sendFile(String data) throws Exception {
        try {

            SocketChannel socketChannel = SocketChannel.open();
            socketChannel.socket().connect(new InetSocketAddress("127.0.0.1", 8081));
            socketChannel.configureBlocking(false);
            while (!socketChannel.finishConnect()) {
                //不断地自旋、等待，或者做一些其他的事情
            }
            Logger.getLogger(SingleReactorSendDemo.class.getName()).info("Client成功连接服务器端");
            Logger.getLogger(SingleReactorSendDemo.class.getName()).info("======== start ========");
            //发送数据
            ByteBuffer sendData = charset.encode(data);
            socketChannel.write(sendData);

            sendData.compact();
            int length = 0;
            while ((length = socketChannel.read(sendData)) > 0) {
                Logger.getLogger(EchoHandler.class.getName()).info(new String(sendData.array(), 0, length));
            }
            //关闭连接
            socketChannel.shutdownOutput();
            socketChannel.close();
            Logger.getLogger(SingleReactorSendDemo.class.getName()).info("======== done ========");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
