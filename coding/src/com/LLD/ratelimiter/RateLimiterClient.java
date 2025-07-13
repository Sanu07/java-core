package com.LLD.ratelimiter;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class RateLimiterClient {

    public static void main(String[] args) {
        RateLimiter rateLimiter = RateLimiter.getInstance();

        int threadCount = 20;
        ExecutorService executor = Executors.newFixedThreadPool(threadCount);

        for (int i = 0; i < threadCount; i++) {
            ApiClient apiClient = new ApiClient(rateLimiter, "user-1", "request-" + (i + 1));
            executor.submit(apiClient);
        }
        executor.shutdown();
    }
}
