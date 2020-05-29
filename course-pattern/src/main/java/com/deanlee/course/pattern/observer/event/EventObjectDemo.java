package com.deanlee.course.pattern.observer.event;

/**
 * java 事件监听demo
 * 首先，为要触发事件的对象（source）定义事件对象； 继承EventObject
 * 其次，为事件对象定义事件监听器； 实现EventListener
 * 最后，定义事件源（source）的类，指定添加监听器的方法。 注册监听 发起通知
 */
public class EventObjectDemo {
    public static void main(String[] args) {
        DoorSource doorSource = new DoorSource();
        doorSource.addDoorListener(new RoomDoorListener());// 给门1增加监听器
        doorSource.addDoorListener(new OtherRoomDoorListener());// 给门2增加监听器
        doorSource.fireWorkspaceClosed();
        doorSource.fireWorkspaceOpened();
    }
}
