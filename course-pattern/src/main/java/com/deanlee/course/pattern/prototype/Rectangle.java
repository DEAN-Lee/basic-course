package com.deanlee.course.pattern.prototype;

/**
 * @author Dean github:https://github.com/DEAN-Lee
 * @Title: Rectangle
 * @Description: 具体现实类
 * @date 2020/5/18 21:45
 */
public class Rectangle extends Shape {
    @Override
    public void draw() {
        System.out.println("Inside Rectangle::draw() method.");
    }

    public Rectangle() {
        type = "Rectangle";
    }

}
