package com.design.behavioral.observer;

public interface EventListener {

    void notify(String eventType, String data);
}
