package com.deanlee.course.pattern.visitor;


/**
 * @author Dean github:https://github.com/DEAN-Lee
 * @Title: ConcreteElementA
 * @Description: 具体元素B
 * @date 2020/6/26 23:15
 */
public class ConcreteElementB implements Element {
    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public String operationB() {
        return "具体元素B的操作。";
    }
}
