package com.deanlee.course.pattern.memento;

/**
 * @author Dean github:https://github.com/DEAN-Lee
 * @Title: Memento
 * @Description: 备忘录（Memento）角色：负责存储发起人的内部状态，在需要的时候提供这些内部状态给发起人。
 * @date 2020/8/3 22:16
 */
public class Memento {
    private String state;

    public Memento(String state) {
        this.state = state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }
}
