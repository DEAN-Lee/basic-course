package com.deanlee.course.pattern.observer.event;

import java.util.EventObject;

/**
 * 事件对象，继承EventObject
 * 桥接监听和事件源之间关系
 */
public class DoorEvent extends EventObject {

    private String doorState = "";// 表示门的状态，有“开”和“关”两种

    /**
     * 事件源+状态
     * @param source
     * @param doorState
     */
    public DoorEvent(Object source, String doorState) {
        super(source);
        this.doorState = doorState;
    }

    public void setDoorState(String doorState) {
        this.doorState = doorState;
    }

    public String getDoorState() {
        return this.doorState;
    }

}
