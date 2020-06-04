package com.deanlee.course.pattern.decorator;

/**
 * @author Dean github:https://github.com/DEAN-Lee
 * @Title: DecoratorPatternDemo
 * @Description: 装饰模式demo
 * @date 2020/6/5 0:11
 */
public class DecoratorPatternDemo {
    public static void main(String[] args) {
        Component p = new ConcreteComponent();
        p.operation();
        System.out.println("---------------------------------");
        Component d = new ConcreteDecorator(p);
        d.operation();
    }
}
