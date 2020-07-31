package com.deanlee.course.pattern.mediator;

/**
 * @author Dean github:https://github.com/DEAN-Lee
 * @Title: MediatorPatternDemo
 * @Description: 中介者模式
 * @date 2020/7/28 23:06
 */
public class MediatorPatternDemo {
    public static void main(String[] args) {
        Mediator md = new ConcreteMediator();
        Colleague c1, c2;
        c1 = new ConcreteColleagueOne();
        c2 = new ConcreteColleagueTwo();
        md.register(c1);
        md.register(c2);
        c1.send();
        System.out.println("-------------");
        c2.send();
    }
}
