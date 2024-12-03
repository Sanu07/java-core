package com.design.structural.flyweight.solution;

public class Rectangle extends Shape {

    private String label;

    public Rectangle(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    @Override
    public void draw(int length, int breadth) {
        System.out.printf("%s :: length -> %s | breadth -> %s%n", label, length, breadth);
    }
}
