package com.deanlee.course.pattern.state;

/**
 *  具体行为A
 */
public class ConcreteStateA implements State {
    @Override
    public void Handle(StateContext context) {
        System.out.println("当前状态是 A.");
        context.setState(new ConcreteStateB());
    }
}
