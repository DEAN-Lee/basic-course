package com.deanlee.course.pattern.adapter;

/**
 * 适配器类：适配器可以调用另一个接口，作为一个转换器，对Adaptee和Target进行适配
 * 适配器类是适配器模式的核心，在对象适配器中，它通过继承Target并关联一个Adaptee对象使二者产生联系
 * 对象适配器：内部关联适配
 */
public class ObjectAdapter implements Target {
    // 适配者是对象适配器的一个属性
    private Adaptee adaptee = new Adaptee();

    @Override
    public void request() {
        adaptee.adapteeRequest();
    }

}
