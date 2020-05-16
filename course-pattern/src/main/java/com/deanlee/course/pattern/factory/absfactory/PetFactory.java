package com.deanlee.course.pattern.factory.absfactory;

/**
 * @author Dean github:https://github.com/DEAN-Lee
 * @Title: CatFactory
 * @Description: 抽象工厂
 * @date 2020/5/16 11:39
 */
public interface PetFactory {
    /**
     * @Description 获取猫咪
     * @Param
     * @Return Cat
     * @author Dean
     * @date 2020/5/16 12:33
     */
    Cat createdCat();

    /**
    * @Description 获取狗
    * @Param
    * @Return Dog
    * @author Dean
    * @date 2020/5/16 22:36
    */
    Dog createdDog();


}
