package org.deanlee.course.jvm;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author LiMeng
 * @version 1.0
 * @date 2019-11-22 14:17
 */
@RunWith(SpringRunner.class)
@SpringBootTest
class ClassLoaderDemoTest {
    @Autowired
    ClassLoaderDemo classLoaderDemo;

    @Test
    void printClassPath() {
        classLoaderDemo.printClassPath();
    }
}