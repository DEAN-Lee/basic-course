package com.deanlee.course.pattern.iterator;

/**
 * @author Dean github:https://github.com/DEAN-Lee
 * @Title: Iterator
 * @Description: 抽象迭代器：定义访问和遍历聚合元素的接口，通常包含 hasNext()、first()、next() 等方法
 * @date 2020/6/24 23:53
 */
public interface Iterator {
    Object first();

    Object next();

    boolean hasNext();
}
