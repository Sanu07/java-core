package com.design.behavioral.visitor;

public interface Visitor {

    double visit(Tobacco tobacco);
    double visit(Necessity necessity);
    double visit(Liquor liquor);
}
