package com.deanlee.course.pattern.observer;

/**
 * 另外一个具体观察者
 */
public class OtherObserver implements Observer {
    @Override
    public void updateSelf() {
        System.out.println(this.getClass().toString()+"另外一个具体观察者");
    }
}
