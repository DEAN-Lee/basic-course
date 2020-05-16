package com.deanlee.course.pattern.factory.absfactory;

/**
 * @author Dean github:https://github.com/DEAN-Lee
 * @Title: HuskyDog
 * @Description: 具体商品 二哈
 * @date 2020/5/16 22:39
 */
public class HuskyDog implements Dog{
    @Override
    public void getDogType() {
        System.out.println("一只二哈 哈士奇");
    }
}
