package com.deanlee.course.pattern.state;

/**
 * @author Dean github:https://github.com/DEAN-Lee
 * @Title: StatePatternDemo
 * @Description: 状态模式设计-三大角色：
 * 环境(context)角色：也称为上下文，它定义了客户感兴趣的接口，维护一个当前状态，并将与状态相关的操作委托给当前状态对象来处理。
 * 抽象状态（State）角色：定义一个接口，用以封装环境对象中的特定状态所对应的行为。
 * 具体状态（Concrete State）角色:具体处理类
 * @date 2020/5/18 21:45
 */
public class StatePatternDemo {
    public static void main(String[] args) {
        StateContext stateContext = new StateContext();
        stateContext.Handle();
        stateContext.Handle();
        stateContext.Handle();

    }
}
