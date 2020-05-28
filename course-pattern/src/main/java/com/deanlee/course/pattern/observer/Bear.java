package com.deanlee.course.pattern.observer;

import java.util.Observable;
import java.util.Observer;

/**
 * 具体观察者。
 */
public class Bear implements Observer {
    @Override
    public void update(Observable o, Object arg) {
        Float price = ((Float) arg).floatValue();
        if (price > 0) {
            System.out.println("上涨" + price + "元，空方伤心了！");
        } else {
            System.out.println("下跌" + (-price) + "元，空方高兴了！");
        }
    }
}
