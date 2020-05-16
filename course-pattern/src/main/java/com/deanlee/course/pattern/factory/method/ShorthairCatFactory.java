package com.deanlee.course.pattern.factory.method;

/**
 * @author Dean github:https://github.com/DEAN-Lee
 * @Title: ShorthairCatFactory
 * @Description: 子工厂具体实现类
 * @date 2020/5/16 13:56
 */
public class ShorthairCatFactory implements CatFactory {


    @Override
    public Cat createdCat() {
        return new ShorthairCat();
    }
}
