package com.design.behavioral.visitor;

public class Main {

    public static void main(String[] args) {

        Liquor liquor = new Liquor(1000);
        Necessity necessity = new Necessity(100);
        Tobacco tobacco = new Tobacco(50);

        TaxVisitor taxVisitor = new TaxVisitor();
        System.out.println(taxVisitor.visit(liquor));
        System.out.println(taxVisitor.visit(necessity));
        System.out.println(taxVisitor.visit(tobacco));
    }
}
