package com.design.structural.proxy;

public class Main {

    public static void main(String[] args) {

        Customer customer = new CustomerImpl();
        System.out.println(customer.getId());
        System.out.println(customer.getOrders());

        System.out.println("\n***************\n");

        Customer proxyCustomer = new CustomerProxyImpl();
        System.out.println(proxyCustomer.getId());
        System.out.println(proxyCustomer.getOrders());
    }
}
