package com.deanlee.course.pattern.builder;

/**
 * @author Dean github:https://github.com/DEAN-Lee
 * @Title: MacComputer
 * @Description: 具体产品实现抽象产品
 * @date 2020/5/17 21:43
 */
public class MacComputer extends Computer {
    @Override
    public void setOs() {
        os = "Mac os Catalina ";
    }
}
