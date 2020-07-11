package com.deanlee.course.pattern.facade;

/**
 * @author Dean github:https://github.com/DEAN-Lee
 * @Title: CircleShape
 * @Description:
 * @date 2020/7/11 22:19
 */
public class CircleShape implements Shape {
    @Override
    public void draw() {
        System.out.println("Circle::draw()");
    }
}
