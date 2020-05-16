package com.deanlee.course.pattern.factory.absfactory;

/**
 * @author Dean github:https://github.com/DEAN-Lee
 * @Title: SamoyedDog
 * @Description: 商品具体shx
 * @date 2020/5/16 22:27
 */
public class SamoyedDog implements Dog {
    @Override
    public void getDogType() {
        System.out.println("一只萨摩耶");
    }
}
