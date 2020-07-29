package com.deanlee.course.pattern.mediator;

/**
 * @author Dean github:https://github.com/DEAN-Lee
 * @Title: Mediator
 * @Description: 抽象中介者（Mediator）角色：它是中介者的接口，提供了同事对象注册与转发同事对象信息的抽象方法
 * @date 2020/7/28 23:07
 */
public interface Mediator {
    public abstract void register(Colleague colleague);
    public abstract void relay(Colleague cl); //转发
}
