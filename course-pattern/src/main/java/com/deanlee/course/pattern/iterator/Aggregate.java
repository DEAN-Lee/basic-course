package com.deanlee.course.pattern.iterator;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Dean github:https://github.com/DEAN-Lee
 * @Title: Aggregate
 * @Description: 抽象聚合类：定义存储、添加、删除聚合对象以及创建迭代器对象的接口
 * @date 2020/6/24 23:52
 */
public interface Aggregate {
    public void add(Object obj);

    public void remove(Object obj);

    public Iterator getIterator();
}
