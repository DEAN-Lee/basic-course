package com.deanlee.course.pattern.visitor;

/**
 * @author Dean github:https://github.com/DEAN-Lee
 * @Title: visitor
 * @Description: 抽象访问角色定义元素操作
 * @date 2020/6/26 23:10
 */
public interface Visitor {
    void visit(ConcreteElementA element);
    void visit(ConcreteElementB element);
}
