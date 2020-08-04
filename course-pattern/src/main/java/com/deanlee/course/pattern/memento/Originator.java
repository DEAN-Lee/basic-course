package com.deanlee.course.pattern.memento;

/**
 * @author Dean github:https://github.com/DEAN-Lee
 * @Title: Originator
 * @Description: 发起人（Originator）角色：记录当前时刻的内部状态信息，提供创建备忘录和恢复备忘录数据的功能，
 *               实现其他业务功能，它可以访问备忘录里的所有信息。
 * @date 2020/8/3 22:16
 */
public class Originator {
    private String state;

    public void setState(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }

    public Memento createMemento() {
        return new Memento(state);
    }

    public void restoreMemento(Memento m) {
        this.setState(m.getState());
    }
}
