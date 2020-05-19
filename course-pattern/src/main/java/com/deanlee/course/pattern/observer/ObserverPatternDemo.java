package com.deanlee.course.pattern.observer;

/**
 * 观察者模式
 */
public class ObserverPatternDemo {
    public static void main(String[] args) {
        //创建观察者目标
        Subject subject = new ConcreteSubject();
        //第一个观察者
        Observer observer = new ConcreteObserver();
        //第二个观察者
        Observer observer1 = new OtherObserver();
        //目标添加观察者
        subject.add(observer);
        subject.add(observer1);
        //目标变动 通知观察者
        subject.notifyObserver();
    }
}
