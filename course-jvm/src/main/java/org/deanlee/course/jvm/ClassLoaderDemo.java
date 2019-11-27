package org.deanlee.course.jvm;

import org.springframework.stereotype.Service;

/**
 * @author LiMeng
 * @version 1.0
 * @date 2019-11-22 14:16
 */
@Service
public class ClassLoaderDemo {
    /**
     * 打印 启动类目录
     */
    public void printClassPath(){
        System.out.println(System.getProperty("sun.boot.class.path"));
        System.out.println("=================");
        System.out.println(System.getProperty("java.ext.dirs"));
        System.out.println("=================");
        System.out.println(System.getProperty("java.class.path"));
    }
}
