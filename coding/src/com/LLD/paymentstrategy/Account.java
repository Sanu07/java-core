package com.LLD.paymentstrategy;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class Account {
    private int accountNo;
    private BigDecimal balance;
}
