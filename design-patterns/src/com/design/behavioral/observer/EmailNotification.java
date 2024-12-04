package com.design.behavioral.observer;

public class EmailNotification implements EventListener {
    @Override
    public void notify(String eventType, String data) {
        System.out.printf("EMAIL :: EventType :: %s Data :: %s", eventType, data);
        System.out.println();
    }
}
