package com.deanlee.course.pattern.responsibility;

/**
 * @author Dean github:https://github.com/DEAN-Lee
 * @Title: TheHandlerImpl
 * @Description:
 * @date 2020/5/23 23:13
 */
public class TheHandlerImpl extends Handler {
    @Override
    public void handleRequest(String request) {
        if (request.equals("one")) {
            System.out.printf("具体处理者1负责处理该请求！");
        } else {
            if (getNext() != null) {
                getNext().handleRequest(request);
            } else {
                System.out.println("没有人处理该请求！");
            }
        }
    }
}
