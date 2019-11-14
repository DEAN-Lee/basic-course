package org.deanlee.course;

import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

/**
 * Unit test for simple App.
 */
public class AppTest {
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue() throws IOException {

        InputStream inputStream = ClassLoader.getSystemResourceAsStream("test.txt");
        int temp = 0;
        while ((temp = inputStream.read()) != -1) {
            System.out.print( (char) temp);
        }

    }
}
