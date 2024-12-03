package com.design.structural.decorator;

// Base component
public class PlainPizza implements Pizza {

    // concrete component that is the base feature used by all
    @Override
    public void bake() {
        System.out.println("Baking plain pizza");
    }
}
