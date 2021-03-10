package org.deanlee.course.networkio.noblockingio;

import java.nio.channels.SocketChannel;

/**
 * @author LiMeng
 * @version 1.0
 * @date 2019-11-21 20:57
 * 同步非阻塞-多路复用实现 channel demo
 */
public class NioReceiveServerDemo {
    public static void main(String[] args) {
        try {
            SocketChannel channel = SocketChannel.open();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
