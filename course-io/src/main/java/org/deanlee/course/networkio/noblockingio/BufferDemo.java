package org.deanlee.course.networkio.noblockingio;

import java.nio.ByteBuffer;

/**
 * @author LiMeng
 * @version 1.0
 * @date 2019-11-21 20:57
 * 同步非阻塞-多路复用实现
 */
public class BufferDemo {
    /**
     * 二进制 测试
     */
    public static void byteBufferTest() {
        ByteBuffer byteBuffer = ByteBuffer.allocate(16);
        byteBuffer.put((byte) 1);
        byteBuffer.put((byte) 2);
        byteBuffer.put((byte) 2);
        byteBuffer.put((byte) 2);
        byteBuffer.put((byte) 2);
        byteBuffer.put((byte) 2);
        byteBuffer.put((byte) 4);
        byteBuffer.put((byte) 4);
        byteBuffer.put((byte) 4);
        byteBuffer.put((byte) 4);
        byteBuffer.put((byte) 4);
        byteBuffer.put((byte) 4);
        byteBuffer.put((byte) 4);
        byteBuffer.put((byte) 4);

        System.out.println(byteBuffer.limit());
        System.out.println(byteBuffer.position());
        System.out.println(byteBuffer.capacity());
        System.out.println(byteBuffer.get(1));



    }

    public static void main(String[] args) {
        byteBufferTest();
    }
}
