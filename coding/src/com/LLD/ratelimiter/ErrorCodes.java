package com.LLD.ratelimiter;

import lombok.Getter;

@Getter
public enum ErrorCodes {

    TOO_MANY_REQUESTS(429, "Too many requests for userId: %s"),
    INVALID(100, "Invalid");

    private final String message;
    private final Integer errorCode;

    ErrorCodes(Integer errorCode, String message) {
        this.errorCode = errorCode;
        this.message = message;
    }
}
