package com.example.pattern.visitor;

public interface Visitable {
    double accept(Visitor visitor);
}
