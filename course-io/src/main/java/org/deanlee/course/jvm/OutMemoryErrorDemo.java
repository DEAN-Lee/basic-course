package org.deanlee.course.jvm;

import org.springframework.stereotype.Service;

import java.io.File;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.List;

/**
 * @author LiMeng
 * @version 1.0
 * @date 2019-11-21 21:33
 */
@Service
public class OutMemoryErrorDemo {
    static String test = "test";

    public void outMemoryTest() {
        List<String> list = new ArrayList<>();
        System.out.println(test);
        while (true){
            String str = test + test;
            test = str;
            list.add(str.intern());
        }
    }

    public void metaOutTest(){
        System.out.println("#########################");
        URL url = null;
        List<ClassLoader> classLoaderList = new ArrayList<ClassLoader>();
        try {
            url = new File("/tmp").toURI().toURL();
            URL[] urls = {url};
            while (true){
                ClassLoader loader = new URLClassLoader(urls);
                classLoaderList.add(loader);
                loader.loadClass("com.paddx.test.memory.Test");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
