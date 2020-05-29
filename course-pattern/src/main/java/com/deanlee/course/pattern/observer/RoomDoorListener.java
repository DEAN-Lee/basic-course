package com.deanlee.course.pattern.observer;

/**
 * 具体监听处理
 */
public class RoomDoorListener implements DoorListener {
    @Override
    public void doorEvent(DoorEvent event) {
        System.out.println("event = RoomDoorListener");
    }
}
