package com.deanlee.course.pattern.observer;

/**
 * 具体目标
 */
public class ConcreteSubject extends Subject {
    @Override
    public void notifyObserver() {
        System.out.println("具体目标发生改变...");
        System.out.println("--------------");

        for (Object obs : observers) {
            ((Observer) obs).updateSelf();
        }
    }
}
