package com.deanlee.course.pattern.command;

/**
 * @author Dean github:https://github.com/DEAN-Lee
 * @Title: Receiver
 * @Description: 执行命令功能的相关操作，是具体命令对象业务的真正实现者。
 * @date 2020/7/24 23:15
 */
public class Receiver {

    public void action() {
        System.out.println("接收者的action()方法被调用...");
    }
}
