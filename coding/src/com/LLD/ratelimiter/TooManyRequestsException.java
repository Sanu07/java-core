package com.LLD.ratelimiter;

public class TooManyRequestsException extends RuntimeException {

    private int statusCode;

    public TooManyRequestsException(String message, int statusCode) {
        super(message);
        this.statusCode = statusCode;
        System.out.println("Error " + message + " :: " + statusCode);
    }
}
