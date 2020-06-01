package com.deanlee.course.pattern.state;

/**
 * 定义一个接口，用以封装环境对象中的特定状态所对应的行为。
 */
public interface State {
    void Handle(StateContext context);
}
