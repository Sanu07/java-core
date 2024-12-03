package com.design.structural.flyweight.solution;

public class PaintApp {
    public static void main(String[] args) {
        int numberOfShapes = 10;
        Shape shape = null;
        for (int i = 0; i < numberOfShapes; i++) {
            if (i % 2 == 0) {
                shape = ShapeFactory.getShape("circle");
                System.out.println("********" + shape.hashCode() + "*********");
                shape.draw(i);
            } else {
                shape = ShapeFactory.getShape("rectangle");
                System.out.println("********" + shape.hashCode() + "*********");
                shape.draw(i * 2, (i * 2) + 1);
            }
        }
        /**
         * ****** Output ******
         *
         * ********1209271652*********
         * circle :: radius -> 0
         * ********1144648478*********
         * rectangle :: length -> 2 | breadth -> 3
         * ********1209271652*********
         * circle :: radius -> 2
         * ********1144648478*********
         * rectangle :: length -> 6 | breadth -> 7
         * ********1209271652*********
         * circle :: radius -> 4
         * ********1144648478*********
         * rectangle :: length -> 10 | breadth -> 11
         * ********1209271652*********
         * circle :: radius -> 6
         * ********1144648478*********
         * rectangle :: length -> 14 | breadth -> 15
         * ********1209271652*********
         * circle :: radius -> 8
         * ********1144648478*********
         * rectangle :: length -> 18 | breadth -> 19
         *
         */
    }
}
