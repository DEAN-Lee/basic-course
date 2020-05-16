package com.deanlee.course.pattern.factory.simple;

/**
 * 客户类，从工厂获取具体猫咪
 * 简单工厂模式实现最为简单，只需要一层封装，就可以实现。客户端只需要知道产品就可以了
 *
 */
public class FactoryPatternDemo {
    public static void main(String[] args) {
        SimpleCatFactory catFactory = new SimpleCatFactory();
        catFactory.getCat("MUPPET").getCatType();
        catFactory.getCat("SHORT").getCatType();
    }
}
