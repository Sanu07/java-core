package com.LLD.paymentstrategy;

import lombok.Data;

@Data
public class Order {

    private int orderId;
    private Payment payment;

}
