package org.deanlee.course;

import org.deanlee.course.jvm.OutMemoryErrorDemo;
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
public class OutMemoryErrorDemoTest {

    @Autowired
    OutMemoryErrorDemo outMemoryErrorDemo;


    @Test
    public void metaOutTest() {
        outMemoryErrorDemo.metaOutTest();
    }

    @Test
    public void outMemoryTest() {
        outMemoryErrorDemo.outMemoryTest();
    }
}
