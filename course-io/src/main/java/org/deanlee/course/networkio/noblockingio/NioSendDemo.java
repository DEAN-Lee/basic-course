package org.deanlee.course.networkio.noblockingio;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.SocketChannel;

/**
 * @author LiMeng
 * @version 1.0
 * @date 2019-11-21 20:57
 * 同步非阻塞-多路复用实现 channel demo
 */
public class NioSendDemo {
    public static void main(String[] args) {
        try {
            //获取通道
            SocketChannel channel = SocketChannel.open();
            // 设置成非阻塞
            channel.configureBlocking(false);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
