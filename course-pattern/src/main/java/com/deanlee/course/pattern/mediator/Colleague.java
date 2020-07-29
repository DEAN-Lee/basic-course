package com.deanlee.course.pattern.mediator;

/**
 * @author Dean github:https://github.com/DEAN-Lee
 * @Title: Colleague
 * @Description:
 * @date 2020/7/29 22:55
 */
public abstract class Colleague {
    protected Mediator mediator;

    public void setMedium(Mediator mediator) {
        this.mediator = mediator;
    }

    public abstract void receive();

    public abstract void send();
}
