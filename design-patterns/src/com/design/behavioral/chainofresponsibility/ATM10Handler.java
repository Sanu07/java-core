package com.design.behavioral.chainofresponsibility;

public class ATM10Handler implements Handler {

    private Handler handler;

    public ATM10Handler(Handler handler) {
        this.handler = handler;
    }

    @Override
    public int addHandler(int amount) {
        int rem = amount % 10;
        int quo = amount / 10;
        System.out.println("10Rs --> " + quo);
        if (handler == null || rem == 0) {
            return quo;
        } else {
            return handler.addHandler(rem);
        }
    }
}
