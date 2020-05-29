package com.deanlee.course.pattern.observer.event;

import java.util.EventListener;

/**
 * 定义监听类
 */
public interface DoorListener extends EventListener {
    public void doorEvent(DoorEvent event);
}
