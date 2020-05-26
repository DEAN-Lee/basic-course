package com.deanlee.course.pattern.adapter;

/**
 * 适配器类：适配器可以调用另一个接口，作为一个转换器，对Adaptee和Target进行适配
 * 适配器类是适配器模式的核心，在对象适配器中，它通过继承Target并关联一个Adaptee对象使二者产生联系
 * 类适配器：通过继承实现适配
 */
public class ClassAdapter extends Adaptee implements Target{
    @Override
    public void request() {
        super.adapteeRequest();
    }
}
