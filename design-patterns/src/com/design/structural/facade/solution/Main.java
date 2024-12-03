package com.design.structural.facade.solution;

public class Main {

    public static void main(String[] args) {
        OrderFacade facade = new OrderFacade();
        facade.processOrder("prod123");
    }
}
