package com.deanlee.course.pattern.template;

/**
 * @author Dean github:https://github.com/DEAN-Lee
 * @Title: ConcreteClass
 * @Description: 实现抽象类中所定义的抽象方法和钩子方法，它们是一个顶级逻辑的一个组成步骤。
 * @date 2020/5/27 23:49
 */
public class ConcreteClass extends AbstractClass {
    @Override
    public void abstractMethod1() {
        System.out.println("抽象方法1的实现被调用...");
    }

    @Override
    public void abstractMethod2() {
        System.out.println("抽象方法2的实现被调用...");
    }
}
