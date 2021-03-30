package org.deanlee.course.networkio.noblockingio.reactor;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.util.Iterator;
import java.util.Set;

/**
 * 单线程 reactor模式
 */
public class SingleReactorServer implements Runnable {

    Selector selector;
    ServerSocketChannel serverSocket;

    SingleReactorServer() throws IOException {
        // 1.获取选择器
        selector = Selector.open();
        // 2.获取通道
        serverSocket = ServerSocketChannel.open();
        // 3.设置为非阻塞
        serverSocket.configureBlocking(false);
        // 4.绑定连接
        InetSocketAddress address = new InetSocketAddress(8081);
        serverSocket.bind(address);
        //注册serverSocket的accept事件
        SelectionKey sk = serverSocket.register(selector, SelectionKey.OP_ACCEPT);
        //将新连接处理器作为附件，绑定到sk选择键
        sk.attach(new AcceptorHandler());
    }

    @Override
    public void run() {
        //选择器轮询
        try {
            while (!Thread.interrupted()) {
                selector.select();
                Set selected = selector.selectedKeys();
                Iterator it = selected.iterator();
                while (it.hasNext()) {
                    //反应器负责dispatch收到的事件
                    SelectionKey sk = (SelectionKey) it.next();
                    dispatch(sk);
                }
                selected.clear();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    /**
     * 反应器的分发方法
     */
    void dispatch(SelectionKey k) {
        Runnable handler = (Runnable) (k.attachment());
        //调用之前绑定到选择键的handler处理器对象
        if (handler != null) {
            handler.run();
        }
    }

    /**
     * 新连接处理器
     */
    class AcceptorHandler implements Runnable {
        @Override
        public void run() {
            System.out.println("in acceptor");
            //接受新连接
            //需要为新连接，创建一个输入输出的handler处理器
        }
    }

    public static void main(String[] args) throws IOException {
        new Thread(new SingleReactorServer()).start();
    }
}
