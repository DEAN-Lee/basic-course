package com.deanlee.course.pattern.decorator;

/**
 * @author Dean github:https://github.com/DEAN-Lee
 * @Title: Decorator
 * @Description: 抽象装饰角色：继承抽象构件，并包含具体构件的实例，可以通过其子类扩展具体构件的功能。
 * @date 2020/6/5 0:06
 */
public class Decorator implements Component {

    private Component component;

    public Decorator(Component component) {
        this.component = component;
    }

    @Override
    public void operation() {
        component.operation();
    }
}
