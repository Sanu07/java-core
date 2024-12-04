package com.design.behavioral.chainofresponsibility;

public class ATMDispenser {

    public static void main(String[] args) {
        ATM1Handler atm1Handler = new ATM1Handler(null);
        ATM10Handler atm10Handler = new ATM10Handler(atm1Handler);
        ATM50Handler atm50Handler = new ATM50Handler(atm10Handler);

        atm50Handler.addHandler(123);
    }
}
