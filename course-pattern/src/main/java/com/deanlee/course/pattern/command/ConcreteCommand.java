package com.deanlee.course.pattern.command;

/**
 * @author Dean github:https://github.com/DEAN-Lee
 * @Title: ConcreteCommand 是抽象命令类的具体实现类，它拥有接收者对象，并通过调用接收者的功能来完成命令要执行的操作。
 * @Description:
 * @date 2020/7/24 23:14
 */
public class ConcreteCommand implements Command {
    private Receiver receiver;

    ConcreteCommand() {
        receiver = new Receiver();
    }

    @Override
    public void execute() {
        receiver.action();
    }
}
