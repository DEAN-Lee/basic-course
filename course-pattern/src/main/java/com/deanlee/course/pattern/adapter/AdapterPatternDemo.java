package com.deanlee.course.pattern.adapter;

/**
 * 适配器测试
 */
public class AdapterPatternDemo {
    public static void main(String[] args) {
//        Target adapterTarget = new ClassAdapter();
//        adapterTarget.request();
        Target target = new ObjectAdapter();
        target.request();
    }
}
