package com.deanlee.course.pattern.factory.method;

/**
 * 工厂方法模式 demo
 * 和简单工厂模式中工厂负责生产所有产品相比，工厂方法模式将生成具体产品的任务分发给具体的产品工厂
 */
public class MethodFactoryDemo  {
    public static void main(String[] args) {
        //创建各自工厂
        CatFactory muppetCatFactory = new MuppetCatFactory();
        CatFactory shorthairCatFactory = new ShorthairCatFactory();
        muppetCatFactory.createdCat().getCatType();
        shorthairCatFactory.createdCat().getCatType();
    }
}
