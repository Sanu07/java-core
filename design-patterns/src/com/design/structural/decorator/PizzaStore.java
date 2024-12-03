package com.design.structural.decorator;

public class PizzaStore {

    public static void main(String[] args) {
        // Give me a simple plain Pizza
        System.out.println("**** Plain Pizza *****");
        Pizza pizza = new PlainPizza();
        pizza.bake();

        // Give me a plain Pizza with veggie toppings
        System.out.println("\n\n**** Plain Pizza with Veggie toppings *****");
        Pizza veggiePizza = new VeggiePizzaDecorator(new PlainPizza());
        veggiePizza.bake();

        // Give me a plain Pizza with veggie toppings and cheese toppings
        System.out.println("\n\n**** Plain Pizza with Veggie and Cheese toppings *****");
        Pizza cheesePizza = new CheesePizzaDecorator(new VeggiePizzaDecorator(new PlainPizza()));
        cheesePizza.bake();
    }
}
