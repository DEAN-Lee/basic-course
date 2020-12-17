package com.deanlee.course.pattern.factory.absfactory;


/**
 * @author Dean github:https://github.com/DEAN-Lee
 * @Title: FactoryProducer
 * @Description: 根据传入的工厂名称获取工厂，再获取工厂内产品
 * @date 2020/5/16 22:46
 */
public class FactoryProducer {
    public static PetFactory getPetFactory(String name) {
        if (name.equalsIgnoreCase("muppet")) {
            return new MuppetCatDogFactory();
        } else if (name.equalsIgnoreCase("shorthair")) {
            return new ShorthairCatDogFactory();
        } else {
            return new MuppetCatDogFactory();
        }
    }

}
