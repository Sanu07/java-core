package com.LLD.kvstore;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Objects;

public class LRUCache {

    private Map<String, String> data = new HashMap<>();
    private LinkedList<String> order = new LinkedList<>();
    private int capacity = 1;


    public void put(String key, String value) {
        if (data.size() == capacity) {
            String removedKey = order.removeLast();
            data.remove(removedKey);
        }
        data.put(key, value);
        order.addFirst(key);
    }

    public String get(String key) {
        String value = data.get(key);
        if (Objects.nonNull(value)) {
            order.remove(key);
            order.addFirst(key);
        }
        return value;
    }
}
