package com.LLD.kvstore;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class InMemKVStore<K, V> implements KVStore<K, V> {

    private final Map<K, Entry<V>> store;

    public InMemKVStore() {
        this.store = new ConcurrentHashMap<>();
    }

    @Override
    public void put(K key, V value, long ttl) {
        store.put(key, new Entry<>(value, ttl));
    }

    @Override
    public V get(K key) {
        Entry<V> vEntry = store.get(key);
        if (vEntry.isExpired()) {
            store.remove(key);
            return null;
        }
        return vEntry.getValue();
    }

    @Override
    public boolean delete(K key) {
        return false;
    }
}
