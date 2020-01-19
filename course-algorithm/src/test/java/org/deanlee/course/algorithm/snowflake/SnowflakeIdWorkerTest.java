package org.deanlee.course.algorithm.snowflake;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author LiMeng
 * @version 1.0
 * @date 2019-11-22 14:17
 */
@RunWith(SpringRunner.class)
@SpringBootTest
class SnowflakeIdWorkerTest {

    @Test
    void printId() {
        SnowflakeIdWorker idWorker = new SnowflakeIdWorker(0, 0);
        for (int i = 0; i < 1000; i++) {
            long id = idWorker.nextId();
            System.out.println(Long.toBinaryString(id));
            System.out.println(id);
        }
    }
}