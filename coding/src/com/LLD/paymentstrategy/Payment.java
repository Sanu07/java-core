package com.LLD.paymentstrategy;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class Payment {
    private String paymentId;
    private String status;
    private BigDecimal amount;
}
