package com.design.structural.facade.problem;

public class Main {

    // client has to handle all the logics
    public static void main(String[] args) {
        OrderProcessor orderProcessor = new OrderProcessor();
        orderProcessor.checkStock("prod123");
        String orderId = orderProcessor.placeOrder("prod123");
        orderProcessor.shipOrder(orderId);
    }
}
