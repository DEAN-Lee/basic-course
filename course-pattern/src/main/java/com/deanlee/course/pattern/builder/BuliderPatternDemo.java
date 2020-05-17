package com.deanlee.course.pattern.builder;

import com.alibaba.fastjson.JSON;

/**
 * @author Dean github:https://github.com/DEAN-Lee
 * @Title: BuliderPatternDemo
 * @Description:
 * @date 2020/5/17 22:59
 */
public class BuliderPatternDemo {
    public static void main(String[] args) {
        Builder builder = new MacBuilder(); //创建构建者类
        Director director = new Director(builder);// 具体流程
        director.bulidComputer("intel", "LED");
        Computer computer = builder.buildComputer();//  产生产品
        System.out.println("Computer :" + JSON.toJSONString(computer));

    }
}
