package org.deanlee.course.networkio.noblockingio.reactor;


import javafx.scene.chart.Chart;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.util.logging.Logger;

/***
 * 回显服务
 */
public class EchoHandler implements Runnable {
    final SocketChannel channel;
    final SelectionKey sk;
    final ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
    static final int RECIEVING = 0, SENDING = 1;
    private Charset charset = Charset.forName("UTF-8");
    int state = RECIEVING;

    EchoHandler(Selector selector, SocketChannel c) throws IOException {
        channel = c;
        c.configureBlocking(false);
//取得选择键，再设置感兴趣的IO事件
        sk = channel.register(selector, 0);
//将Handler自身作为选择键的附件
        sk.attach(this);
//注册Read就绪事件
        sk.interestOps(SelectionKey.OP_READ);
        selector.wakeup();
    }

    @Override
    public void run() {
        try {
            if (state == SENDING) {
//写入通道
                channel.write(byteBuffer);
//写完后,准备开始从通道读,byteBuffer切换成写入模式
                byteBuffer.clear();
//写完后,注册read就绪事件
                sk.interestOps(SelectionKey.OP_READ);
//写完后,进入接收的状态
                state = RECIEVING;
            } else if (state == RECIEVING) {
//从通道读
                int length = 0;
                while ((length = channel.read(byteBuffer)) > 0) {
                    Logger.getLogger(EchoHandler.class.getName()).info(new String(byteBuffer.array(), 0, length));
                }
                byteBuffer.clear();
                byteBuffer.put(charset.encode("Hello NOI World,Client"));
//读完后，准备开始写入通道,byteBuffer切换成读取模式
                byteBuffer.flip();
//读完后，注册write就绪事件
                sk.interestOps(SelectionKey.OP_WRITE);
//读完后,进入发送的状态
                state = SENDING;
            }
//处理结束了, 这里不能关闭select key，需要重复使用
//sk.cancel();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
