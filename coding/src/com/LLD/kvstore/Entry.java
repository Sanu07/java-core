package com.LLD.kvstore;

import lombok.Data;

@Data
public class Entry<V> {

    private final V value;
    private final long expiryTime;

    public Entry(V value, long ttl) {
        this.value = value;
        this.expiryTime = ttl > 0 ? System.currentTimeMillis() + ttl : 0;
    }

    public boolean isExpired() {
        return expiryTime != 0 && System.currentTimeMillis() > expiryTime;
    }
}
