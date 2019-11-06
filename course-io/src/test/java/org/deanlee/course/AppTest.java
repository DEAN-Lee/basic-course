package org.deanlee.course;

import org.junit.Test;

import java.io.InputStream;

/**
 * Unit test for simple App.
 */
public class AppTest {
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue() {

        InputStream inputStream = ClassLoader.getSystemResourceAsStream("test.txt");
        System.out.println(inputStream.toString());
        System.out.println("tttt");
    }
}
