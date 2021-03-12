package org.deanlee.course.networkio.noblockingio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.charset.Charset;
import java.util.Iterator;

/**
 * @author LiMeng
 * @version 1.0
 * @date 2019-11-21 20:57
 * 同步非阻塞-多路复用实现 channel demo
 */
public class NioDatagramChannelServerDemo {
    private Charset charset = Charset.forName("UTF-8");

    public static void main(String[] args) throws Exception {
        // 启动客户端连接
        NioDatagramChannelServerDemo client = new NioDatagramChannelServerDemo();
        // 传输文件
        client.receive();

    }

    public void receive() throws IOException {
//获取DatagramChannel数据报通道
        DatagramChannel datagramChannel = DatagramChannel.open();
//设置为非阻塞模式
        datagramChannel.configureBlocking(false);
//绑定监听地址
        datagramChannel.bind(new InetSocketAddress("127.0.0.1", 8080));
        System.out.println("UDP服务器启动成功！");
//开启一个通道选择器
        Selector selector = Selector.open();
//将通道注册到选择器
        datagramChannel.register(selector, SelectionKey.OP_READ);
//通过选择器，查询IO事件
        while (selector.select() > 0) {
            Iterator<SelectionKey> iterator = selector.selectedKeys()
                    .iterator();
            ByteBuffer buffer = ByteBuffer.allocate(1024);
//迭代IO事件
            while (iterator.hasNext()) {
                SelectionKey selectionKey = iterator.next();
//可读事件，有数据到来
                if (selectionKey.isReadable()) {
//读取DatagramChannel数据报通道的数据
                    SocketAddress client = datagramChannel.receive(buffer);
                    buffer.flip();
                    System.out.println(new String(buffer.array(), 0, buffer.limit()));
                    buffer.clear();
                }
            }
            iterator.remove();
        }
//关闭选择器和通道
        selector.close();
        datagramChannel.close();
    }
}
