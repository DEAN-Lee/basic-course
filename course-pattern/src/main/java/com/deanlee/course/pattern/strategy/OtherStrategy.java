package com.deanlee.course.pattern.strategy;

public class OtherStrategy implements Strategy {
    @Override
    public void strategyMethod() {
        System.out.println("策略类二执行");
    }
}
