package com.deanlee.course.pattern.factory.simple;

/**
 * 具体实现
 */
public class ShorthairCat implements Cat {
    @Override
    public void getCatType() {
        System.out.println("获取一只英短猫咪");
    }
}
