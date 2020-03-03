package com.deanlee.course.proxy;

/**
 * 目标类（实现上述接口）
 */
public class RealSubject implements Subject{
    @Override
    public void test() {
        System.out.println("target method");
    }
}
