package com.example.pattern.decorator.model;

import com.example.pattern.decorator.interfaces.IceCream;
import com.example.pattern.decorator.interfaces.IceCreamDecorator;

public class MintIceCream extends IceCreamDecorator {
    public MintIceCream(IceCream iceCream) {
        super(iceCream);
    }

    @Override
    public double cost() {
        System.out.println("Adding Mint Ice-Cream! additonal cost $1.50");
        return 1.50 + super.cost();
    }
}
