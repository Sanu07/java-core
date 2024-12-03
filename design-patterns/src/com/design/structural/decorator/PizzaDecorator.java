package com.design.structural.decorator;
// Base Decorator
public class PizzaDecorator implements Pizza {

    private final Pizza pizza;

    public PizzaDecorator(Pizza pizza) {
        this.pizza = pizza;
    }

    @Override
    public void bake() {
        pizza.bake();
    }
}
