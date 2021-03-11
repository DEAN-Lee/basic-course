package org.deanlee.course.networkio.noblockingio;

import javax.xml.crypto.Data;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;
import java.nio.channels.FileChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.util.Date;
import java.util.Scanner;
import java.util.logging.Logger;

/**
 * @author LiMeng
 * @version 1.0
 * @date 2019-11-21 20:57
 * 同步非阻塞-多路复用实现 channel demo
 */
public class NioDaagramChannelDemo {
    private Charset charset = Charset.forName("UTF-8");

    public static void main(String[] args) throws Exception {
        // 启动客户端连接
        NioDaagramChannelDemo client = new NioDaagramChannelDemo();
        // 传输文件
        client.send();

    }

    public void send() throws IOException {
//获取DatagramChannel数据报通道
        DatagramChannel dChannel = DatagramChannel.open();
//设置为非阻塞
        dChannel.configureBlocking(false);
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        Scanner scanner = new Scanner(System.in);
        System.out.println("UDP客户端启动成功！");
        System.out.println("请输入发送内容:");
        while (scanner.hasNext()) {
            String next = scanner.next();
            buffer.put((new Date() + " >>" + next).getBytes());
            buffer.flip();
//通过DatagramChannel数据报通道发送数据
            dChannel.send(buffer, new InetSocketAddress("127.0.0.1", 8080));
            buffer.clear();
        }
//操作四：关闭DatagramChannel数据报通道
        dChannel.close();
    }
}
