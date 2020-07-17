package com.deanlee.course.pattern.composite;

/**
 * @author Dean github:https://github.com/DEAN-Lee
 * @Title: Leaf
 * @Description: 子节点
 * @date 2020/7/17 23:06
 */
public class Leaf implements Component {
    private String name;

    @Override
    public void add(Component c) {

    }

    @Override
    public void remove(Component c) {

    }

    @Override
    public Component getChild(int i) {
        return null;
    }

    @Override
    public void operation() {
        System.out.println("树叶" + name + "：被访问！");
    }
}
