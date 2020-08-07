package com.deanlee.course.pattern.interpreter;

/**
 * 非终结符表达式（Nonterminal Expression）角色：也是抽象表达式的子类，用来实现文法中与非终结符相关的操作，文法中的每条规则都对应于一个非终结符表达式。
 */
public class AndExpression implements Expression {
    private Expression catColor = null;
    private Expression catType = null;

    public AndExpression(Expression catColor, Expression catType) {
        this.catColor = catColor;
        this.catType = catType;
    }

    @Override
    public boolean interpret(String info) {
        String s[] = info.split("的");
        return catColor.interpret(s[0]) && catType.interpret(s[1]);
    }
}
