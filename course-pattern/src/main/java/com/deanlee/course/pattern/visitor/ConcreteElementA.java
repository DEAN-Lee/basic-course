package com.deanlee.course.pattern.visitor;


/**
 * @author Dean github:https://github.com/DEAN-Lee
 * @Title: ConcreteElementA
 * @Description: 具体元素A
 * @date 2020/6/26 23:15
 */
public class ConcreteElementA implements Element {
    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public String operationA() {
        return "具体元素A的操作。";
    }
}
