package com.design.structural.flyweight.problem;

public class PaintApp {

    public static void main(String[] args) {
        int numberOfShapes = 10;

        Shape[] shapes = new Shape[numberOfShapes];

        for (int i = 0; i < shapes.length; i++) {
            if (i % 2 == 0) {
                Circle circle = new Circle("circle");
                circle.setRadius(i);
                shapes[i] = circle;
            } else {
                Rectangle rectangle = new Rectangle("rectangle");
                rectangle.setLength(2 * i);
                rectangle.setBreadth((2 * i) + 1);
                shapes[i] = rectangle;
            }
        }

        for (Shape shape : shapes) {
            // always new objects will get created
            System.out.println("********" + shape.hashCode() + "********");
            /**
             * *** Output ***
             *
             * ********1209271652********
             * circle :: radius -> 0
             * ********559670971********
             * rectangle :: length -> 2 | breadth -> 3
             * ********1144648478********
             * circle :: radius -> 2
             * ********1576861390********
             * rectangle :: length -> 6 | breadth -> 7
             * ********600746945********
             * circle :: radius -> 4
             * ********1566502717********
             * rectangle :: length -> 10 | breadth -> 11
             * ********1458849419********
             * circle :: radius -> 6
             * ********1824835605********
             * rectangle :: length -> 14 | breadth -> 15
             * ********981661423********
             * circle :: radius -> 8
             * ********269468037********
             * rectangle :: length -> 18 | breadth -> 19
             *
             */
            shape.draw();
        }
    }
}
