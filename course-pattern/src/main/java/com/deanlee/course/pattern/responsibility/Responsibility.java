package com.deanlee.course.pattern.responsibility;

/**
 * @author Dean github:https://github.com/DEAN-Lee
 * @Title: Responsibility
 * @Description: 客户端类
 * @date 2020/5/23 23:16
 */
public class Responsibility {
    public static void main(String[] args) {
        //组装责任链
        Handler handler = new TheHandlerImpl();
        Handler handler1 = new NextHandlerImpl();
        handler.setNext(handler);
        //提交请求
        handler1.handleRequest("two");
    }
}
