package com.deanlee.course.pattern.prototype;

/**
 * @author Dean github:https://github.com/DEAN-Lee
 * @Title: PrototypePatternDemo
 * @Description: demo示例 JAVA 深拷贝 和 浅拷贝区别
 * @date 2020/5/18 21:51
 */
public class PrototypePatternDemo {
    public static void main(String[] args) throws CloneNotSupportedException {
        ShapeCache.loadCache();

        Shape clonedShape = (Shape) ShapeCache.getShape("1");
        System.out.println("Shape : " + clonedShape.getType());

        Shape clonedShape2 = (Shape) ShapeCache.getShape("1");
        System.out.println("Shape : " + clonedShape2.getType());
        System.out.println("clonedShape == clonedShape2: " + clonedShape == clonedShape2 + "");

        Shape clonedShape3 = (Shape) ShapeCache.getShape("3");
        System.out.println("Shape : " + clonedShape3.getType());

    }
}
