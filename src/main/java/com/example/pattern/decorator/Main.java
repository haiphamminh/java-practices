package com.example.pattern.decorator;

import com.example.pattern.decorator.interfaces.IceCream;
import com.example.pattern.decorator.model.BasicIceCream;
import com.example.pattern.decorator.model.MintIceCream;
import com.example.pattern.decorator.model.VanillaIceCream;

public class Main {
    public static void main(String[] args) {
        IceCream basicIceCream = new BasicIceCream();
        System.out.println("Total cost $" + basicIceCream.cost());
        System.out.println("---------------------------");

        // Add Vanilla to the order
        // wrapping basic Ice-Cream with Vanilla
        IceCream vanilla = new VanillaIceCream(basicIceCream);
        System.out.println("Total cost is: $" + vanilla.cost());
        System.out.println("---------------------------");

        // Add Mint to the order
        // wrapping basic Ice-Cream with Vanilla
        IceCream mint = new MintIceCream(vanilla);
        System.out.println("Total cost is: $" + mint.cost());
    }
}
