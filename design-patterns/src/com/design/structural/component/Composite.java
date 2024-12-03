package com.design.structural.component;

import java.util.ArrayList;
import java.util.List;

public class Composite implements Component {

    private final String name;

    public Composite(String name) {
        this.name = name;
    }

    private final List<Component> components = new ArrayList<>();

    public void add(Component component) {
        components.add(component);
    }

    @Override
    public void showPrice() {
        System.out.println(name);
        components.forEach(component -> {
            component.showPrice();
        });
    }
}
