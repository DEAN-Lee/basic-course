package com.deanlee.course.pattern.visitor;


/**
 * @author Dean github:https://github.com/DEAN-Lee
 * @Title: Element
 * @Description: 抽象元素
 * @date 2020/6/26 23:14
 */
public interface Element {
    void accept(Visitor visitor);
}
