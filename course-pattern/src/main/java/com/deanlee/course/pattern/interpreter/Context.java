package com.deanlee.course.pattern.interpreter;

/**
 * 环境（Context）角色：通常包含各个解释器需要的数据或是公共的功能，一般用来传递被所有解释器共享的数据，后面的解释器可以从这里获取这些值。
 */
public class Context {
    private String[] catColors = {"黑色", "白色", "灰色"};
    private String[] catTypes = {"布偶", "英短", "美短"};
    private Expression catTypeExp;

    public Context() {
        Expression catColor = new TerminalExpression(catColors);
        Expression catType = new TerminalExpression(catTypes);
        catTypeExp = new AndExpression(catColor, catType);
    }

    public void freeRide(String info) {
        boolean ok = catTypeExp.interpret(info);
        if (ok) {
            System.out.println("您是带的是" + info + "，您本次免费！");
        } else {
            System.out.println("您是带的是" + info + "，您不符合活动条件，本次付费2元！");
        }
    }
}
