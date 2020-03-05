package org.deanlee.course.tcp.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    private static final String template = "Hello, %s!";

    @GetMapping("/getWord")
    public String getWord(@RequestParam(value = "name", defaultValue = "word") String name) {
        return String.format(template, name);
    }
}
