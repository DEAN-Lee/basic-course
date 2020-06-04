package com.deanlee.course.pattern.decorator;

/**
 * @author Dean github:https://github.com/DEAN-Lee
 * @Title: ConcreteComponent
 * @Description: 具体构建组件
 * @date 2020/6/5 0:03
 */
public class ConcreteComponent implements Component {

    public ConcreteComponent(){
        System.out.println("创建具体构建组件角色");
    }

    @Override
    public void operation() {
        System.out.println("调用具体构件角色的方法operation()");
    }
}
