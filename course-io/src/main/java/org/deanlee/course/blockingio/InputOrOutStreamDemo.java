package org.deanlee.course.blockingio;

import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author LiMeng
 * @version 1.0
 * @date 2019-11-07 11:32
 */
@Service
public class InputOrOutStreamDemo {

    public void readFileDemo(){
        //同类下 有配置文件
        InputStream inputStream = InputOrOutStreamDemo.class.getResourceAsStream("test.txt");
        //编译目录下
        InputStream inputStream1 = ClassLoader.getSystemResourceAsStream("test.txt");
        try {
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
