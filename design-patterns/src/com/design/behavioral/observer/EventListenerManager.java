package com.design.behavioral.observer;

import java.util.*;

public class EventListenerManager {

    Map<String, Set<EventListener>> listeners;

    public EventListenerManager(String ... operations) {
        listeners = new HashMap<>();
        for (String op: operations) {
            listeners.put(op, new HashSet<>());
        }
    }

    public void subscribe(String eventType, EventListener listener) {
        listeners.get(eventType).add(listener);
    }

    public void unsubscribe(String eventType, EventListener listener) {
        listeners.get(eventType).remove(listener);
    }

    public void notify(String eventType, String data) {
        Set<EventListener> eventListeners = listeners.get(eventType);
        for (EventListener listener: eventListeners) {
            listener.notify(eventType, data);
        }
    }
}
