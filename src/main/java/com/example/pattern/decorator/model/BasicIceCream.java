package com.example.pattern.decorator.model;

import com.example.pattern.decorator.interfaces.IceCream;

public class BasicIceCream implements IceCream {
    public BasicIceCream() {
        System.out.println("Creating a basic Ice-Cream!");
    }

    @Override
    public double cost() {
        System.out.println("Basic Ice-Cream cost $0.50");
        return 0.50;
    }
}
