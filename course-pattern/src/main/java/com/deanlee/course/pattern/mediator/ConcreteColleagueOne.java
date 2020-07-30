package com.deanlee.course.pattern.mediator;

/**
 * @author Dean github:https://github.com/DEAN-Lee
 * @Title: ConcreteColleagueOne
 * @Description:具体同事类（Concrete Colleague）角色：是抽象同事类的实现者，当需要与其他同事对象交互时，由中介者对象负责后续的交互。
 * @date 2020/7/30 22:02
 */
public class ConcreteColleagueOne extends Colleague {
    @Override
    public void receive() {
        System.out.println("具体同事类1收到请求。");

    }

    @Override
    public void send() {
        System.out.println("具体同事类1发出请求。");
        mediator.relay(this); //请中介者转发
    }
}
