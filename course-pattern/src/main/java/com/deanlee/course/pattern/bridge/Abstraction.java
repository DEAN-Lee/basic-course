package com.deanlee.course.pattern.bridge;

/**
 * @author Dean github:https://github.com/DEAN-Lee
 * @Title: Abstraction
 * @Description: 抽象化（Abstraction）角色：定义抽象类，并包含一个对实现化对象的引用。
 * @date 2020/7/1 23:19
 */
public abstract class Abstraction {
    protected Implementor imple;

    protected Abstraction(Implementor imple) {
        this.imple = imple;
    }

    public abstract void Operation();
}
