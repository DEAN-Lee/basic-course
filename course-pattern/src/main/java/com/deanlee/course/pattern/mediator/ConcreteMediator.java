package com.deanlee.course.pattern.mediator;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Dean github:https://github.com/DEAN-Lee
 * @Title: ConcreteMediator
 * @Description: 具体中介者（ConcreteMediator）角色：实现中介者接口，定义一个 List 来管理同事对象，协调各个同事角色之间的交互关系，因此它依赖于同事角色。
 * @date 2020/7/30 22:00
 */
public class ConcreteMediator implements Mediator {
    private List<Colleague> colleagues = new ArrayList<Colleague>();

    public void register(Colleague colleague) {
        if (!colleagues.contains(colleague)) {
            colleagues.add(colleague);
            colleague.setMedium(this);
        }
    }

    public void relay(Colleague cl) {
        for (Colleague ob : colleagues) {
            if (!ob.equals(cl)) {
                ((Colleague) ob).receive();
            }
        }
    }
}
