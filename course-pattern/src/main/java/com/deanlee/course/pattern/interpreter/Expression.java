package com.deanlee.course.pattern.interpreter;

/**
 * 抽象表达式（Abstract Expression）角色：定义解释器的接口，约定解释器的解释操作，主要包含解释方法 interpret()。
 */
public interface Expression {
    public boolean interpret(String info);
}
