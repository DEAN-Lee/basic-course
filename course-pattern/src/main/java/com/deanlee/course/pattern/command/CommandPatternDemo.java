package com.deanlee.course.pattern.command;

/**
 * @author Dean github:https://github.com/DEAN-Lee
 * @Title: CommandPatternDemo
 * @Description: 命令模式
 * @date 2020/7/22 21:57
 */
public class CommandPatternDemo {
    public static void main(String[] args) {
        Command cmd = new ConcreteCommand();
        Invoker ir = new Invoker(cmd);
        System.out.println("客户访问调用者的call()方法...");
        ir.call();
    }
}
