package com.deanlee.course.pattern.interpreter;

/**
 * @author Dean github:https://github.com/DEAN-Lee
 * @Title: InterpreterPatternDemo
 * @Description: 解释器模式
 * @date 2020-8-6 18:32:27
 */
public class InterpreterPatternDemo {
    public static void main(String[] args) {
        Context c=new Context();
        c.freeRide("黑色的布偶");
        c.freeRide("白色的加菲");
        c.freeRide("白色的英短");
        c.freeRide("白色的英短");
        c.freeRide("灰色的美短");
    }
}
