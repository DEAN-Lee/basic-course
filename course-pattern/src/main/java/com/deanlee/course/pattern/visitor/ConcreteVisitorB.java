package com.deanlee.course.pattern.visitor;

/**
 * @author Dean github:https://github.com/DEAN-Lee
 * @Title: ConcreteVisitorB
 * @Description: 具体访问者B
 * @date 2020/6/26 23:12
 */
public class ConcreteVisitorB implements Visitor {
    @Override
    public void visit(ConcreteElementA element) {
        System.out.println("具体访问者A访问-->"+element.operationA());
    }

    @Override
    public void visit(ConcreteElementB element) {
        System.out.println("具体访问者A访问-->"+element.operationB());
    }
}
