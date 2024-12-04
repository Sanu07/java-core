package com.design.behavioral.chainofresponsibility;

public class ATM50Handler implements Handler {

    private Handler handler;

    public ATM50Handler(Handler handler) {
        this.handler = handler;
    }

    @Override
    public int addHandler(int amount) {
        int rem = amount % 50;
        int quo = amount / 50;
        System.out.println("50Rs --> " + quo);
        if (handler == null || rem == 0) {
            return quo;
        } else {
            return handler.addHandler(rem);
        }
    }
}
