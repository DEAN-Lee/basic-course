package com.deanlee.course.pattern.memento;

/**
 * @author Dean github:https://github.com/DEAN-Lee
 * @Title: MementoPatternDemo
 * @Description: 备忘录模式
 * @date 2020/8/3 22:16
 */
public class MementoPatternDemo {
    public static void main(String[] args) {
        Originator or = new Originator();
        Caretaker cr = new Caretaker();
        or.setState("S0");
        System.out.println("初始状态:" + or.getState());
        cr.setMemento(or.createMemento()); //保存状态
        or.setState("S1");
        System.out.println("新的状态:" + or.getState());
        or.restoreMemento(cr.getMemento()); //恢复状态
        System.out.println("恢复状态:" + or.getState());
    }
}
