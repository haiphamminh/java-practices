package com.example.pattern.decorator.model;

import com.example.pattern.decorator.interfaces.IceCream;
import com.example.pattern.decorator.interfaces.IceCreamDecorator;

public class VanillaIceCream extends IceCreamDecorator {
    public VanillaIceCream(IceCream iceCream) {
        super(iceCream);
    }

    @Override
    public double cost() {
        System.out.println("Adding Vanilla Ice-Cream! additional cost $1");
        return 1.0 + super.cost();
    }
}
