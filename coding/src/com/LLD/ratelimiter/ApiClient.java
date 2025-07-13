package com.LLD.ratelimiter;

public class ApiClient implements Runnable {

    private final RateLimiter rateLimiter;
    private final String userId;
    private final String requestId;

    public ApiClient(RateLimiter rateLimiter, String userId, String requestId) {
        this.rateLimiter = rateLimiter;
        this.userId = userId;
        this.requestId = requestId;
    }

    @Override
    public void run() {
        Boolean requestAllowed = this.rateLimiter.isRequestAllowed(this.userId);
        if (requestAllowed) {
            System.out.println("Passed --> " + requestId);
        } else {
            System.out.println("Failed --> " + requestId);
        }
    }
}
