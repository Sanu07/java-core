package com.LLD.paymentstrategy;

import java.math.BigDecimal;

public class UPIPayment implements PaymentProcessor {
    @Override
    public String pay(BigDecimal amount) {
        return "COMPLETED-UPI";
    }
}
