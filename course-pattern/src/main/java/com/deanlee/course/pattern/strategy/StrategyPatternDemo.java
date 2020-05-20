package com.deanlee.course.pattern.strategy;

import java.util.Arrays;

/**
 * 策略模式 demo
 * 1、抽象策略类
 * 2、实现策略类
 * 3、定义环境量
 */
public class StrategyPatternDemo {
    public static void main(String[] args) {
        Context context = new Context();
        Strategy strategy = new TheStrategy();
        context.setStrategy(strategy);
        context.strategyMethod();
        System.out.println("------------------------------");
        Strategy otherStrategy = new OtherStrategy();
        context.setStrategy(otherStrategy);
        context.strategyMethod();
    }
}
