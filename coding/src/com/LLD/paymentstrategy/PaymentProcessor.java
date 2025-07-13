package com.LLD.paymentstrategy;

import java.math.BigDecimal;

public interface PaymentProcessor {

    String pay(BigDecimal amount);
}
