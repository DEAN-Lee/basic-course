package com.deanlee.course.pattern.builder;

/**
 * @author Dean github:https://github.com/DEAN-Lee
 * @Title: MacBuilder
 * @Description: 建造者具体实现类
 * @date 2020/5/17 21:48
 */
public class MacBuilder extends Builder {
    private Computer computer = new MacComputer();

    @Override
    void buildCpu(String name) {
        computer.setCpu(name);
    }

    @Override
    void buildDisplay(String name) {
        computer.setDisplay(name);
    }

    @Override
    void buildOs() {
        computer.setOs();
    }

    @Override
    Computer buildComputer() {
        return computer;
    }
}
