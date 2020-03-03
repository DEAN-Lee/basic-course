package com.deanlee.course.proxy;

/**
 * 代理类（实现上述接口）
 */
public class Proxy implements Subject {
    private RealSubject realSubject;

    public Proxy(RealSubject realSubject) {
        this.realSubject = realSubject;
    }

    @Override
    public void test() {
        System.out.println("Before");
        try {
            realSubject.test();
        } catch (Exception e) {
            System.out.println("ex:" + e.getMessage());
            throw e;
        } finally {
            System.out.println("After");
        }
    }
}
