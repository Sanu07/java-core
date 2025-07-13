package com.LLD.paymentstrategy;

import java.math.BigDecimal;

public class PaymentStrategy implements PaymentProcessor {

    private final PaymentProcessor paymentProcessor;

    public PaymentStrategy(PaymentProcessor paymentProcessor) {
        this.paymentProcessor = paymentProcessor;
    }

    @Override
    public String pay(BigDecimal amount) {
        return paymentProcessor.pay(amount);
    }
}
