package com.deanlee.course.pattern.factory.absfactory;

public class ShorthairCat implements Cat {
    @Override
    public void getCatType() {
        System.out.println("获取一只英短猫咪");
    }
}
