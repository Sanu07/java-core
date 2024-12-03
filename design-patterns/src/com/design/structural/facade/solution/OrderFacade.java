package com.design.structural.facade.solution;

import com.design.structural.facade.problem.OrderProcessor;

public class OrderFacade {

    OrderProcessor orderProcessor = new OrderProcessor();

    public void processOrder(String product) {
        if (orderProcessor.checkStock(product)) {
            String orderId = orderProcessor.placeOrder(product);
            orderProcessor.shipOrder(orderId);
        }
    }
}
