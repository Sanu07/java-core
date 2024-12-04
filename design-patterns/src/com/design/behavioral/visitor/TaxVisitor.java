package com.design.behavioral.visitor;

public class TaxVisitor implements Visitor {
    @Override
    public double visit(Tobacco tobacco) {
        System.out.println("Calculating tax for Tobacco");
        return tobacco.getPrice() * 0.1;
    }

    @Override
    public double visit(Necessity necessity) {
        System.out.println("Calculating tax for Necessity");
        return necessity.getPrice() * 0.2;
    }

    @Override
    public double visit(Liquor liquor) {
        System.out.println("Calculating tax for Liquor");
        return liquor.getPrice() * 0.3;
    }
}
