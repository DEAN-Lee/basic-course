package com.deanlee.course.pattern.builder;

/**
 * @author Dean github:https://github.com/DEAN-Lee
 * @Title: Builder
 * @Description: 抽象建造类
 * @date 2020/5/17 21:46
 */
public abstract class Builder {
    abstract void buildCpu(String name);

    abstract void buildDisplay(String name);

    abstract void buildOs();

    abstract Computer buildComputer();
}
