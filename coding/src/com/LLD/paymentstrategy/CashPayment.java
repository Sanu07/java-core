package com.LLD.paymentstrategy;

import java.math.BigDecimal;

public class CashPayment implements PaymentProcessor {
    @Override
    public String pay(BigDecimal amount) {
        return "COMPLETED-CASH";
    }
}
