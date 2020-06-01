package com.deanlee.course.pattern.state;

/**
 * 具体行为B
 */
public class ConcreteStateB implements State {
    @Override
    public void Handle(StateContext context) {
        System.out.println("当前状态是 B.");
        context.setState(new ConcreteStateA());
    }
}
