package com.deanlee.course.pattern.prototype;

/**
 * @author Dean github:https://github.com/DEAN-Lee
 * @Title: Circle
 * @Description: 具体实现类
 * @date 2020/5/18 21:48
 */
public class Circle extends Shape{
    public Circle() {
        type = "Circle";
    }

    @Override
    void draw() {
        System.out.println("Inside Circle::draw() method.");
    }
}
