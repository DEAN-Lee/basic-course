package com.deanlee.course.pattern.factory.simple;

/**
 * 工程类，获取具体实例
 */
public class SimpleCatFactory {

    //使用 getCat 方法获取形状类型的对象
    public SimpleCat getCat(String catType) {
        if (catType == null) {
            return null;
        }
        if (catType.equalsIgnoreCase("MUPPET")) {
            return new MuppetCat();
        } else if (catType.equalsIgnoreCase("SHORT")) {
            return new ShorthairCat();
        }
        return null;
    }
}
