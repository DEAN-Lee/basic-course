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
        //初始
        ByteBuffer byteBuffer = ByteBuffer.allocate(16);
        //赋值
        byteBuffer.put((byte) 1);
        byteBuffer.put((byte) 2);
        byteBuffer.put((byte) 3);
        byteBuffer.put((byte) 4);
        byteBuffer.put((byte) 5);
        byteBuffer.put((byte) 6);
        byteBuffer.put((byte) 7);
        byteBuffer.put((byte) 8);
        byteBuffer.put((byte) 9);
        byteBuffer.put((byte) 10);
        byteBuffer.put((byte) 11);
        byteBuffer.put((byte) 12);
        byteBuffer.put((byte) 13);
        byteBuffer.put((byte) 14);
        //打印参数值
        System.out.println("before------>limit " + byteBuffer.limit());
        System.out.println("before------>position" + byteBuffer.position());
        System.out.println("before------>capacity" + byteBuffer.capacity());
        //切换模式读模式
        byteBuffer.flip();
        //输出参数值
        System.out.println("after------>limit" + byteBuffer.limit());
        System.out.println("after------>position" + byteBuffer.position());
        System.out.println("after------>capacity" + byteBuffer.capacity());
        //输出2buffer数量
        for (int i = 0; i < 2; i++) {
            System.out.println(byteBuffer.get());
        }

        //输出3buffer数量 后 参数值
        System.out.println("after1------>limit" + byteBuffer.limit());
        System.out.println("after1------>position" + byteBuffer.position());
        System.out.println("after1------>capacity" + byteBuffer.capacity());
        //输出内容
        for (int i = 0; i < 4; i++) {
            System.out.println(byteBuffer.get());
        }
        // 输出4buffer数量 后 参数值
        System.out.println("after2------>limit" + byteBuffer.limit());
        System.out.println("after2------>position" + byteBuffer.position());
        System.out.println("after2------>capacity" + byteBuffer.capacity());
    }

    public static void main(String[] args) {
        byteBufferTest();
    }
}
