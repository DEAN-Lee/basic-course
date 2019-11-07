package org.deanlee.course.blockingio;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author LiMeng
 * @version 1.0
 * @date 2019-11-07 11:32
 */
public class InputOrOutStreamDemo {
    public static void main(String[] args) {
        InputStream inputStream = InputOrOutStreamDemo.class.getResourceAsStream("test.txt");
        InputStream inputStream1 = ClassLoader.getSystemResourceAsStream("test.txt");
        try {
            System.out.println(new File("").getAbsolutePath());
            System.out.println(new File("").getPath());
            System.out.println(new File("").getCanonicalPath());
            int temp = 0;
            while ((temp = inputStream.read()) != -1) {
                System.out.print((char) temp );
            }
            System.out.println("---------------------");
            int temp1 = 0;
            while ((temp1 = inputStream1.read()) != -1) {
                System.out.print((char) temp1 );
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
