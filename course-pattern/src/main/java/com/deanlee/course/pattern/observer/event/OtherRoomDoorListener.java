package com.deanlee.course.pattern.observer.event;

public class OtherRoomDoorListener implements DoorListener {
    @Override
    public void doorEvent(DoorEvent event) {
        System.out.println("event = OtherRoomDoorListener");
    }
}
