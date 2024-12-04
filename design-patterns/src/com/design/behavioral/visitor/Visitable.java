package com.design.behavioral.visitor;

public interface Visitable {

    double accept(Visitor visitor);
}
