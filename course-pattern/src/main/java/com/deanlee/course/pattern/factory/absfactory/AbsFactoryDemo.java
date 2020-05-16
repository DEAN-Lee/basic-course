package com.deanlee.course.pattern.factory.absfactory;

/**
 * 工厂方法模式 demo
 * 和简单工厂模式中工厂负责生产所有产品相比，工厂方法模式将生成具体产品的任务分发给具体的产品工厂
 */
public class AbsFactoryDemo {
    public static void main(String[] args) {
        //创建各自工厂
        PetFactory muppetPetDogFactory = FactoryProducer.getPetFactory("muppet");
        PetFactory shorthairPetDogFactory = FactoryProducer.getPetFactory("shorthair");
        muppetPetDogFactory.createdCat().getCatType();
        muppetPetDogFactory.createdDog().getDogType();
        shorthairPetDogFactory.createdCat().getCatType();
        shorthairPetDogFactory.createdDog().getDogType();
    }
}
