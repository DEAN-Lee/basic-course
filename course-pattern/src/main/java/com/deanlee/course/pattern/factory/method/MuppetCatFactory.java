package com.deanlee.course.pattern.factory.method;

/**
 * 工程类，获取具体实例
 */
public class MuppetCatFactory implements CatFactory{
    @Override
    public Cat createdCat() {
        return new MuppetCat();
    }
}
