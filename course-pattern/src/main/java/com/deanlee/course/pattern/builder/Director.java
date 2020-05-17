package com.deanlee.course.pattern.builder;

/**
 * @author Dean github:https://github.com/DEAN-Lee
 * @Title: Director
 * @Description: 负责具体构造
 * @date 2020/5/17 22:57
 */
public class Director {
    Builder builder = null;

    public Director(Builder builder) {
        this.builder = builder;
    }

    public void bulidComputer(String cpu,String display){
        builder.buildDisplay(display);
        builder.buildCpu(cpu);
        builder.buildOs();
    }
}
