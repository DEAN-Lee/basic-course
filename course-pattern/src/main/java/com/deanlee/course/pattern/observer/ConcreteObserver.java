package com.deanlee.course.pattern.observer;

/**
 * 具体观察者
 */
public class ConcreteObserver implements Observer {
    @Override
    public void updateSelf() {
        System.out.println(this.getClass().toString()+"第一个具体观察者");
    }
}
