package com.design.structural.flyweight.solution;

public class Circle extends Shape {

    private String label;

    public Circle(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    @Override
    public void draw(int radius) {
        System.out.printf("%s :: radius -> %s%n", label, radius);
    }
}
