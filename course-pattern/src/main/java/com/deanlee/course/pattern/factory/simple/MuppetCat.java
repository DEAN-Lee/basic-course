package com.deanlee.course.pattern.factory.simple;

/**
 * 实现
 */
public class MuppetCat implements SimpleCat{
    @Override
    public void getCat() {
        System.out.println("获取一只布偶");
    }
}
