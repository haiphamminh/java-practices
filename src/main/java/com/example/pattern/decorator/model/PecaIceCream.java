package com.example.pattern.decorator.model;

import com.example.pattern.decorator.interfaces.IceCream;
import com.example.pattern.decorator.interfaces.IceCreamDecorator;

public class PecaIceCream extends IceCreamDecorator {
    public PecaIceCream(IceCream iceCream) {
        super(iceCream);
    }
}
