package org.deanlee.course;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) throws IOException {

//        InputStream inputStream = ClassLoader.getSystemResourceAsStream("test.txt");
//
//        System.out.println("args = [" + inputStream.available() + "]");
//        int test = 0;
//        while ((test = inputStream.read()) != -1) {
//            System.out.print( (char)test);
//        }
        App app = new App();
        app.streamDemo();
    }

    public void streamDemo(){
        InputStream inputStream = new BufferedInputStream(System.in);
        System.out.println("输入");
        try {
            System.out.println((char) inputStream.read());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
