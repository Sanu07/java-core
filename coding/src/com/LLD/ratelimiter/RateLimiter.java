package com.LLD.ratelimiter;

import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

@Slf4j
public class RateLimiter {

    private final Map<String, Bucket> customerApiRateLimiterMap;
    private final Lock lock;
    private static final Lock instanceLock = new ReentrantLock(true);

    private RateLimiter() {
        this.customerApiRateLimiterMap = new ConcurrentHashMap<>();
        this.lock = new ReentrantLock(true);
    }

    private static volatile RateLimiter INSTANCE;

    public static RateLimiter getInstance() {
        if (INSTANCE == null) {
            try {
                if (instanceLock.tryLock(100, TimeUnit.MILLISECONDS)) {
                    if (INSTANCE == null) {
                        INSTANCE = new RateLimiter();
                    }
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } finally {
                instanceLock.unlock();
            }
        }
        return INSTANCE;
    }


    public Boolean isRequestAllowed(String userId) {
        try {
            Bucket bucket = customerApiRateLimiterMap.computeIfAbsent(userId,
                    k -> new Bucket(System.currentTimeMillis(), Constants.BUCKET_SIZE));
            return bucket.isAllowedRequest(userId);
        } catch (TooManyRequestsException ex) {

        }
        return false;
    }
}
