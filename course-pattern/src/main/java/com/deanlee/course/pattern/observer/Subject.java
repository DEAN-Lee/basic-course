package com.deanlee.course.pattern.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * 抽象目标
 */
public abstract class Subject {
    protected List<Observer> observers = new ArrayList<Observer>();
    //添加监听者
    public void add(Observer observer){
        observers.add(observer);
    }

    //去除监听者
    public void remove(Observer observer){
        observers.remove(observer);
    }

    //通知观察者方法
    public abstract void notifyObserver();
}
