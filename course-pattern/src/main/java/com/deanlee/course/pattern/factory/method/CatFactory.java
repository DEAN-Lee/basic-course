package com.deanlee.course.pattern.factory.method;

/**
 * @author Dean github:https://github.com/DEAN-Lee
 * @Title: CatFactory
 * @Description: 抽象工厂
 * @date 2020/5/16 11:39
 */
public interface CatFactory {
  /**
  * @Description 获取猫咪
  * @Param
  * @Return CatFactory
  * @author Dean
  * @date 2020/5/16 12:33
  */
    Cat createdCat();
}
