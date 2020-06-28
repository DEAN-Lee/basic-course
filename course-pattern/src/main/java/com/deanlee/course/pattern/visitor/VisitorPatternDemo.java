package com.deanlee.course.pattern.visitor;

/**
 * @author Dean github:https://github.com/DEAN-Lee
 * @Title: VisitorPatternDemo
 * @Description: 访问者类Demo
 * @date 2020/6/26 23:20
 */
public class VisitorPatternDemo {
    public static void main(String[] args) {

        ObjectStructure os = new ObjectStructure();
        os.add(new ConcreteElementA());
        os.add(new ConcreteElementB());
        Visitor visitor = new ConcreteVisitorA();
        os.accept(visitor);
        System.out.println("------------------------");
        visitor = new ConcreteVisitorB();
        os.accept(visitor);
    }
}
