package com.deanlee.course.pattern.memento;

/**
 * @author Dean github:https://github.com/DEAN-Lee
 * @Title: Originator
 * @Description: 管理者（Caretaker）角色:对备忘录进行管理，提供保存与获取备忘录的功能，但其不能对备忘录的内容进行访问与修改。
 * @date 2020/8/3 22:16
 */
public class Caretaker {
    private Memento memento;

    public void setMemento(Memento m) {
        memento = m;
    }

    public Memento getMemento() {
        return memento;
    }
}
