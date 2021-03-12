package org.deanlee.course.networkio.noblockingio;

import org.deanlee.course.networkio.blockingio.InputOrOutStreamDemo;
import sun.nio.ch.IOUtil;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author LiMeng
 * @version 1.0
 * @date 2019-11-21 20:57
 * 同步非阻塞-多路复用实现 channel demo
 */
public class FileChannelDemo {
    public static void main(String[] args) {
        try {
            fileReadDemo();
            nioCopyResouceFile();
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
        inChannel.close();
        stream.close();
    }

    /**
     * 复制两个资源目录下的文件
     */
    public static void nioCopyResouceFile() {
        String src = new File("").getAbsolutePath() + "/course-io/src/main/resources/test.txt";
        String dest = new File("").getAbsolutePath() + "/course-io/src/main/resources/desTtest.txt";
        nioCopyFile(src, dest);
    }

    /**
     * nio方式复制文件
     *
     * @param srcPath
     * @param destPath
     */
    public static void nioCopyFile(String srcPath, String destPath) {
        File srcFile = new File(srcPath);
        File destFile = new File(destPath);
        try {
            //如果目标文件不存在，则新建
            if (!destFile.exists()) {
                destFile.createNewFile();
            }
            long startTime = System.currentTimeMillis();
            FileInputStream fis = null;
            FileOutputStream fos = null;
            FileChannel inChannel = null;
            FileChannel outchannel = null;
            try {
                fis = new FileInputStream(srcFile);
                fos = new FileOutputStream(destFile);
                inChannel = fis.getChannel();
                outchannel = fos.getChannel();
                int length = -1;
                ByteBuffer buf = ByteBuffer.allocate(1024);
                //从输入通道读取到buf
                while ((length = inChannel.read(buf)) != -1) {
                //第一次切换：翻转buf，变成读取模式
                    buf.flip();
                    int outlength = 0;
                    //将buf写入到输出的通道
                    while ((outlength = outchannel.write(buf)) != 0) {
                        System.out.println("写入的字节数：" + outlength);
                    }
                    //第二次切换：清除buf，变成写入模式
                    buf.clear();
                }
                //强制刷新到磁盘
                outchannel.force(true);
            } finally {
                //关闭所有的可关闭对象
                outchannel.close();
                fos.close();
                inChannel.close();
                fis.close();
            }
            long endTime = System.currentTimeMillis();
            System.out.println("base复制毫秒数：" + (endTime - startTime));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
