package com.design.behavioral.strategy;

public class UppercaseStrategy implements PrintStrategy {

    @Override
    public String formatString(String input) {
        return input.toUpperCase();
    }
}
