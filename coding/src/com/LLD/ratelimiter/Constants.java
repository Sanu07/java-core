package com.LLD.ratelimiter;

public interface Constants {

    // 5 requests in 10 sec per user

    Integer BUCKET_SIZE = 5;
    Integer TOKEN_COUNT = 5;
    Integer WINDOW_DURATION_IN_MILLIS = 10_000;
}
