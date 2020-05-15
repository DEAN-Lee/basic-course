package com.deanlee.course.pattern.factory.simple;

/**
 * 客户类，从工厂获取具体猫咪
 */
public class FactoryPatternDemo {
    public static void main(String[] args) {
        SimpleCatFactory catFactory = new SimpleCatFactory();
        catFactory.getCat("MUPPET").getCat();
        catFactory.getCat("SHORT").getCat();
    }
}
