package com.deanlee.course.pattern.iterator;

/**
 * @author Dean github:https://github.com/DEAN-Lee
 * @Title: IteratorPatternDemo
 * @Description: 迭代器模式 demo
 * @date 2020/6/24 23:55
 */
public class IteratorPatternDemo {
    public static void main(String[] args) {
        Aggregate ag = new ConcreteAggregate();
        ag.add("github");
        ag.add("gitlab");
        ag.add("gitee");
        System.out.print("聚合的内容有：");
        Iterator it = ag.getIterator();
        while (it.hasNext()) {
            Object ob = it.next();
            System.out.print(ob.toString() + "\t");
        }
        Object ob = it.first();
        System.out.println("\nFirst：" + ob.toString());
    }
}
