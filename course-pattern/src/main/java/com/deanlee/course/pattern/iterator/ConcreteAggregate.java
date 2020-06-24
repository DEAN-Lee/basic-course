package com.deanlee.course.pattern.iterator;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Dean github:https://github.com/DEAN-Lee
 * @Title: ConcreteAggregate
 * @Description: 实现抽象聚合类，返回一个具体迭代器的实例。
 * @date 2020/6/24 23:56
 */
public class ConcreteAggregate implements Aggregate {
    private List<Object> list=new ArrayList<Object>();
    @Override
    public void add(Object obj) {
        list.add(obj);
    }

    @Override
    public void remove(Object obj) {
        list.remove(obj);
    }

    @Override
    public Iterator getIterator() {
        return(new ConcreteIterator(list));
    }
}
