package com.design.structural.facade.problem;

public class OrderProcessor {

    public boolean checkStock(String product) {
        System.out.println("Product is available");
        return true;
    }

    public String placeOrder(String product) {
        System.out.println("Place Order");
        return "abc123";
    }

    public void shipOrder(String orderId) {
        System.out.println("Ship Order");
    }
}
