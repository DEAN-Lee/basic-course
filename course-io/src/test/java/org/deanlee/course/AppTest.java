package org.deanlee.course;

import org.deanlee.course.networkio.blockingio.InputOrOutStreamDemo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Unit test for simple App.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class AppTest {
    /**
     * Rigorous Test :-)
     */
    @Autowired
    InputOrOutStreamDemo inputOrOutStreamDemo;

    @Test
    public void readInputFileDemo() throws Exception {

        inputOrOutStreamDemo.readInputFileDemo();

    }

    @Test
    public void outputStreamDemo(){
        try {
//            inputOrOutStreamDemo.outFileDemo();
            inputOrOutStreamDemo.outCacheFileDemo();
//            System.out.println(this.getClass().getClassLoader());
//            System.out.println(this.getClass().getClassLoader().getParent());
//            System.out.println(this.getClass().getClassLoader().getParent().getParent());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
