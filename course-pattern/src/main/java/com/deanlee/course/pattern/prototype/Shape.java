package com.deanlee.course.pattern.prototype;

/**
 * @author Dean github:https://github.com/DEAN-Lee
 * @Title: Shape
 * @Description: 抽象一个父类
 * @date 2020/5/18 21:43
 */
public abstract class Shape implements Cloneable {
    private String id;

    protected String type;

    abstract void draw();

    public String getType() {
        return type;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
