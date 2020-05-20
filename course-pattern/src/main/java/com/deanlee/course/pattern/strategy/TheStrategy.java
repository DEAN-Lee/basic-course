package com.deanlee.course.pattern.strategy;

public class TheStrategy implements Strategy {
    @Override
    public void strategyMethod() {
        System.out.printf("策略类一执行");
    }
}
