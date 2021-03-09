package org.deanlee.course.networkio.noblockingio;

import org.deanlee.course.networkio.blockingio.InputOrOutStreamDemo;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author LiMeng
 * @version 1.0
 * @date 2019-11-21 20:57
 * 同步非阻塞-多路复用实现 channel demo
 */
public class ChannelDemo {
    public static void main(String[] args) {
        try {
            fileReadDemo();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static void fileReadDemo() throws Exception {
        // 创建文件流
        FileInputStream stream = new FileInputStream(new File("").getAbsolutePath() + "/course-io/src/main/resources/test.txt");
        //获取通道
        FileChannel inChannel = stream.getChannel();
        ByteBuffer buf = ByteBuffer.allocate(49);
        int bytesRead = inChannel.read(buf);
        while (bytesRead != -1) {
            System.out.println("Read " + bytesRead);
            buf.flip();
            while (buf.hasRemaining()) {
                System.out.println((char) buf.get());
            }
            buf.clear();
            bytesRead = inChannel.read(buf);
        }
        stream.close();
    }


}
