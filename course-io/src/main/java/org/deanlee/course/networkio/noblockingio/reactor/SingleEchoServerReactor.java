package org.deanlee.course.networkio.noblockingio.reactor;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;
import java.util.logging.Logger;

/**
 * 单线程 reactor模式
 * 服务器绑定分发消息
 */
public class SingleEchoServerReactor implements Runnable {
    Selector selector;
    ServerSocketChannel serverSocket;

    SingleEchoServerReactor() throws IOException {
        // 1.获取选择器
        selector = Selector.open();
        // 2.获取通道
        serverSocket = ServerSocketChannel.open();
        // 3.设置为非阻塞
        serverSocket.configureBlocking(false);
        // 4.绑定连接
        InetSocketAddress address = new InetSocketAddress(8081);
        serverSocket.bind(address);
        // 5.将通道注册到选择器上,并注册的IO事件为：“接收新连接”
        SelectionKey sk = serverSocket.register(selector, SelectionKey.OP_ACCEPT);
        //将新连接处理器作为附件，绑定到sk选择键
        sk.attach(new AcceptorHandler());

        Logger.getLogger(SingleEchoServerReactor.class.getName()).info("服务器端启动成功！！");
    }

    //轮询和分发事件
    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                selector.select();
                Set<SelectionKey> selected = selector.selectedKeys();
                Iterator<SelectionKey> it = selected.iterator();
                while (it.hasNext()) {
//反应器负责dispatch收到的事件
                    SelectionKey sk = it.next();
                    dispatch(sk);
                }
                selected.clear();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    void dispatch(SelectionKey sk) {
        Runnable handler = (Runnable) sk.attachment();
//调用之前attach绑定到选择键的handler处理器对象
        if (handler != null) {
            handler.run();
        }
    }

    // Handler:新连接处理器
    class AcceptorHandler implements Runnable {
        @Override
        public void run() {
            try {
                SocketChannel channel = serverSocket.accept();
                if (channel != null) {
                    new EchoHandler(selector, channel);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws IOException {
        new Thread(new SingleEchoServerReactor()).start();
    }
}
