package org.deanlee.course;

import org.deanlee.course.networkio.blockingio.InputOrOutStreamDemo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author LiMeng
 * @version 1.0
 * @date 2019-11-14 11:51
 */
@SpringBootApplication
public class Application implements CommandLineRunner {

    @Autowired
    InputOrOutStreamDemo inputOrOutStreamDemo;

    public static void main(String[] args) throws Exception {

        //disabled banner, don't want to see the spring logo
        SpringApplication app = new SpringApplication(Application.class);
        app.setBannerMode(Banner.Mode.OFF);
        app.run(args);

    }


    @Override
    public void run(String... args) throws Exception {
//        inputOrOutStreamDemo.readInputFileDemo();
    }

}
