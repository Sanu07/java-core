package com.design.structural.flyweight.solution;

import java.util.HashMap;
import java.util.Map;

public class ShapeFactory {

    private static final Map<String, Shape> shapeMap = new HashMap<>();

    public static Shape getShape(String type) {
        Shape shape;
        if (shapeMap.containsKey(type)) {
            shape = shapeMap.get(type);
        } else {
            if ("circle".equals(type)) {
                shape = new Circle("circle");
            } else {
                shape = new Rectangle("rectangle");
            }
            shapeMap.put(type, shape);
        }
        return shape;
    }
}
