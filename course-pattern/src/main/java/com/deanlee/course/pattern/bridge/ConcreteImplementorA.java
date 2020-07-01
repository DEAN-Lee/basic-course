package com.deanlee.course.pattern.bridge;

/**
 * @author Dean github:https://github.com/DEAN-Lee
 * @Title: ConcreteImplementorA
 * @Description: 具体实现化（Concrete Implementor）角色：给出实现化角色接口的具体实现。
 * @date 2020/7/1 23:22
 */
public class ConcreteImplementorA implements Implementor {
    @Override
    public void OperationImpl() {
        System.out.println("具体实现化(Concrete Implementor)角色被访问" );
    }
}
