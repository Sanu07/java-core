package com.design.behavioral.strategy;

public class Main {

    public static void main(String[] args) {
        PrintStrategy lowercaseStrategy = new LowercaseStrategy();
        PrintStrategy uppercaseStrategy = new UppercaseStrategy();

        Executor executor = new Executor(lowercaseStrategy);
        executor.formatString("Good Morning");

        executor.setPrintStrategy(uppercaseStrategy);
        executor.formatString("Good morning");
    }
}
