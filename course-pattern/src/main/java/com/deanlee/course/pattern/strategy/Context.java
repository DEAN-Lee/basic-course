package com.deanlee.course.pattern.strategy;

/**
 * 环境类 持有抽象策略，执行抽象策略方法
 */
public class Context {
    private Strategy strategy;

    public Strategy getStrategy() {
        return strategy;
    }

    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }

    public void strategyMethod() {
        strategy.strategyMethod();
    }
}
