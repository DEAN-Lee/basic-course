package com.deanlee.course.pattern.prototype;

/**
 * @author Dean github:https://github.com/DEAN-Lee
 * @Title: Square
 * @Description: 具体实现类
 * @date 2020/5/18 21:47
 */
public class Square extends Shape {
    public Square() {
        type = "Square";
    }

    @Override
    void draw() {
        System.out.println("Inside Square::draw() method.");
    }
}
