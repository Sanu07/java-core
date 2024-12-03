package com.design.structural.flyweight.problem;

public class Circle implements Shape {

    private String label;
    private int radius;

    public Circle(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    @Override
    public void draw() {
        System.out.printf("%s :: radius -> %s%n", label, radius);
    }
}
