package com.design.structural.proxy;

import java.util.List;

public class CustomerProxyImpl implements Customer {

    CustomerImpl customer = new CustomerImpl();

    @Override
    public int getId() {
        return customer.getId();
    }

    @Override
    public List<Order> getOrders() {
        return List.of(
                new Order(1, "p1", 1),
                new Order(2, "p2", 2),
                new Order(3, "p3", 3));
    }
}
