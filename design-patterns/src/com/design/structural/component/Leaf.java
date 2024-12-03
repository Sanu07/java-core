package com.design.structural.component;

public class Leaf implements Component {

    private int price;
    private String name;

    public Leaf(int price, String name) {
        this.price = price;
        this.name = name;
    }

    @Override
    public void showPrice() {
        System.out.println(name + " : " + price);
    }
}
