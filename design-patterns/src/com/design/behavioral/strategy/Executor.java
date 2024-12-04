package com.design.behavioral.strategy;

public class Executor {

    public PrintStrategy getPrintStrategy() {
        return printStrategy;
    }

    public void setPrintStrategy(PrintStrategy printStrategy) {
        this.printStrategy = printStrategy;
    }

    private PrintStrategy printStrategy;

    public Executor(PrintStrategy printStrategy) {
        this.printStrategy = printStrategy;
    }

    public void formatString(String input) {
        System.out.println(printStrategy.getClass().getName() + " :: " + printStrategy.formatString(input));
    }
}
