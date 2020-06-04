package com.deanlee.course.pattern.decorator;

/**
 * @author Dean github:https://github.com/DEAN-Lee
 * @Title: ConcreteDecorator
 * @Description: 具体装饰角色
 * @date 2020/6/5 0:09
 */
public class ConcreteDecorator extends Decorator {
    public ConcreteDecorator(Component component) {
        super(component);
    }

    @Override
    public void operation() {
        super.operation();
        addedFunction();
    }

    public void addedFunction() {
        System.out.println("为具体构件角色增加额外的功能addedFunction()");
    }
}
