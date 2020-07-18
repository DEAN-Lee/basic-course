package com.deanlee.course.pattern.composite;

import java.util.ArrayList;

/**
 * @author Dean github:https://github.com/DEAN-Lee
 * @Title: Composite
 * @Description: 枝干
 * @date 2020/7/18 22:48
 */
public class Composite implements Component {
    private ArrayList<Component> children = new ArrayList<Component>();

    public void add(Component c) {
        children.add(c);
    }

    public void remove(Component c) {
        children.remove(c);
    }

    public Component getChild(int i) {
        return children.get(i);
    }

    public void operation() {
        for (Object obj : children) {
            ((Component) obj).operation();
        }
    }
}
