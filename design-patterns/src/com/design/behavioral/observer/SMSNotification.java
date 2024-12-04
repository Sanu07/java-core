package com.design.behavioral.observer;

public class SMSNotification implements EventListener {
    @Override
    public void notify(String eventType, String data) {
        System.out.printf("SMS :: EventType :: %s Data :: %s", eventType, data);
        System.out.println();
    }
}
