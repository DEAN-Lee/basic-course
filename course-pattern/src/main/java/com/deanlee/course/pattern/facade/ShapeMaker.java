package com.deanlee.course.pattern.facade;

/**
 * @author Dean github:https://github.com/DEAN-Lee
 * @Title: ShapeMaker
 * @Description: 外观类.封装接口
 * @date 2020/7/12 23:09
 */
public class ShapeMaker {
    private Shape circle;
    private Shape rectangle;
    private Shape square;

    public ShapeMaker() {
        circle = new CircleShape();
        rectangle = new RectangleShape();
        square = new SquareShape();
    }

    public void drawCircle() {
        circle.draw();
    }

    public void drawRectangle() {
        rectangle.draw();
    }

    public void drawSquare() {
        square.draw();
    }
}
