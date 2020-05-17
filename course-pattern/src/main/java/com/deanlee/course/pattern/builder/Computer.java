package com.deanlee.course.pattern.builder;

/**
 * @author Dean github:https://github.com/DEAN-Lee
 * @Title: Computer
 * @Description: 抽象产品
 * @date 2020/5/17 21:41
 */
public abstract class Computer {
    protected String cpu;
    protected String display;
    protected String os;

    public String getCpu() {
        return cpu;
    }

    public void setCpu(String cpu) {
        this.cpu = cpu;
    }

    public String getDisplay() {
        return display;
    }

    public void setDisplay(String display) {
        this.display = display;
    }

    public String getOs() {
        return os;
    }

    public abstract void setOs();
}
