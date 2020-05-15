package com.deanlee.course.pattern.factory.simple;

public class ShorthairCat implements SimpleCat {
    @Override
    public void getCat() {
        System.out.println("获取一只英短猫咪");
    }
}
