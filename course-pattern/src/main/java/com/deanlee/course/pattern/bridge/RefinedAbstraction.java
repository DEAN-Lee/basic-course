package com.deanlee.course.pattern.bridge;

/**
 * @author Dean github:https://github.com/DEAN-Lee
 * @Title: RefinedAbstraction
 * @Description: 扩展抽象化（Refined    Abstraction）角色：是抽象化角色的子类，实现父类中的业务方法，并通过组合关系调用实现化角色中的业务方法。
 * @date 2020/7/1 23:21
 */
public class RefinedAbstraction extends Abstraction {
    protected RefinedAbstraction(Implementor imple) {
        super(imple);
    }

    public void Operation() {
        System.out.println("扩展抽象化(Refined Abstraction)角色被访问");
        imple.OperationImpl();
    }
}
