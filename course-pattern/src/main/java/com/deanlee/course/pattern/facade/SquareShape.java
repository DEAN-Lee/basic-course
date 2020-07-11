package com.deanlee.course.pattern.facade;

/**
 * @author Dean github:https://github.com/DEAN-Lee
 * @Title: Square Shape
 * @Description:
 * @date 2020/7/11 22:19
 */
public class SquareShape implements Shape {
    @Override
    public void draw() {
        System.out.println("Square::draw()");
    }
}
