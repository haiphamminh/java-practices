package com.example.pattern.visitor;

public class Shirt implements  Visitable{
    private double price;

    public Shirt(double price) {
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public double accept(Visitor visitor) {
        return visitor.visitor(this);
    }
}
