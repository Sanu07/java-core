package com.design.behavioral.observer;

public class EventGeneratorService {

    public EventListenerManager getManager() {
        return manager;
    }

    public void setManager(EventListenerManager manager) {
        this.manager = manager;
    }

    private EventListenerManager manager;

    public EventGeneratorService(EventListenerManager manager) {
        this.manager = manager;
    }

    public void success() {
        manager.notify("SUCCESS", "successfully processed");
    }

    public void failure() {
        manager.notify("FAILED", "processing failed");
    }
}
