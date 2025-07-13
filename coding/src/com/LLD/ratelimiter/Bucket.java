package com.LLD.ratelimiter;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Bucket {

    private Long lastRefillTimestamp;
    private Integer tokenCount;

    public Bucket(Long lastRefillTimestamp, Integer tokenCount) {
        this.lastRefillTimestamp = lastRefillTimestamp;
        this.tokenCount = tokenCount;
    }

    public synchronized boolean isAllowedRequest(String userId) {
        long currentTimeInMillis = System.currentTimeMillis();

        // if duration is passed, Refill and reduce token count by 1
        if (lastRefillTimestamp + Constants.WINDOW_DURATION_IN_MILLIS < currentTimeInMillis) {
            tokenCount = (Constants.TOKEN_COUNT - 1);
            lastRefillTimestamp = (currentTimeInMillis);
            return true;
        } else if (lastRefillTimestamp + Constants.WINDOW_DURATION_IN_MILLIS >= currentTimeInMillis) {
            // if within duration, reduce the token count by 1
            Integer currentTokenCount = tokenCount;
            if (currentTokenCount < 1) {
                throw new TooManyRequestsException("Too many Requests for userId: " + userId, 429);
            }
            tokenCount = (currentTokenCount - 1);
            return true;
        }
        return false;
    }
}
