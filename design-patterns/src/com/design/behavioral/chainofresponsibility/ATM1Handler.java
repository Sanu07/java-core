package com.design.behavioral.chainofresponsibility;

public class ATM1Handler implements Handler {

    private Handler handler;

    public ATM1Handler(Handler handler) {
        this.handler = handler;
    }

    @Override
    public int addHandler(int amount) {
        System.out.println("1Rs --> " + amount);
        if (handler == null) {
            return amount;
        } else {
            return handler.addHandler(amount);
        }
    }
}
