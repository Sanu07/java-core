package com.design.structural.flyweight.problem;

public class Rectangle implements Shape {

    private String label;
    private int length;
    private int breadth;

    public Rectangle(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getBreadth() {
        return breadth;
    }

    public void setBreadth(int breadth) {
        this.breadth = breadth;
    }

    @Override
    public void draw() {
        System.out.printf("%s :: length -> %s | breadth -> %s%n", label, length, breadth);
    }
}
