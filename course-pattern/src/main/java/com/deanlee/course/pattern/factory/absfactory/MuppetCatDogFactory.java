package com.deanlee.course.pattern.factory.absfactory;

/**
 * 工程类，获取具体实例
 */
public class MuppetCatDogFactory implements PetFactory {
    @Override
    public Cat createdCat() {
        return new MuppetCat();
    }

    @Override
    public Dog createdDog() {
        return new SamoyedDog();
    }
}
