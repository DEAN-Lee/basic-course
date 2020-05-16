package com.deanlee.course.pattern.factory.absfactory;

/**
 * 实现
 */
public class MuppetCat implements Cat {

    @Override
    public void getCatType() {
        System.out.println("获取一只布偶");
    }
}
