package com.LLD.kvstore;

public interface KVStore<K, V> {
    void put(K key, V value, long ttl);
    V get(K key);
    boolean delete(K key);
}
