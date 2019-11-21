package org.deanlee.course.networkio.blockingio;

import org.springframework.stereotype.Service;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * @author LiMeng
 * @version 1.0
 * @date 2019-11-07 11:32
 */
@Service
public class InputOrOutStreamDemo {

    public void readInputFileDemo() {
        try {
            //同类下 配置文件信息
            InputStream inputStream = InputOrOutStreamDemo.class.getResourceAsStream("test.txt");

            //编译目录下
            InputStream inputStream1 = ClassLoader.getSystemResourceAsStream("test.txt");

            System.out.println(new File("").getAbsolutePath());
            System.out.println(new File("").getCanonicalPath());
            //制定目录
            InputStream inputStream2 = new FileInputStream(new File("").getAbsolutePath() + "/src/main/resources/test.txt");


            int temp = 0;
            while ((temp = inputStream.read()) != -1) {
                System.out.print((char) temp);
            }
            System.out.println("---------------------");

            int temp1 = 0;
            while ((temp1 = inputStream1.read()) != -1) {
                System.out.print((char) temp1);
            }

            System.out.println("---------------------");

            int temp2 = 0;
            while ((temp2 = inputStream2.read()) != -1) {
                System.out.print((char) temp2);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void outFileDemo() throws Exception {
        //编译目录下
        InputStream inputStream1 = ClassLoader.getSystemResourceAsStream("test.txt");

        OutputStream outputStream = new FileOutputStream(new File("").getAbsolutePath() + "/src/main/resources/copyTest.txt");

        int temp1 = 0;
        int i = 0;
        while ((temp1 = inputStream1.read()) != -1) {
            System.out.println("-------" + ++i);
            outputStream.write(temp1);
        }
        inputStream1.close();
        outputStream.close();

    }


    public void outCacheFileDemo() throws Exception {
        //编译目录下
        InputStream inputStream1 = ClassLoader.getSystemResourceAsStream("test.txt");
        BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream1);

        OutputStream outputStream = new FileOutputStream(new File("").getAbsolutePath() + "/src/main/resources/copyTest.txt");
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(outputStream);

        int temp1 = 0;
        int i = 0;
        byte[] bs = new byte[1024];
        while ((temp1 = bufferedInputStream.read(bs)) != -1) {
            System.out.println("-------" + ++i);
            bufferedOutputStream.write(bs, 0, temp1);
        }
        bufferedInputStream.close();
        bufferedOutputStream.close();
        inputStream1.close();
        outputStream.close();

    }

    public static void main(String[] args) {
        InputOrOutStreamDemo inputOrOutStreamDemo = new InputOrOutStreamDemo();
        inputOrOutStreamDemo.readInputFileDemo();

    }
}
