package com.example.pattern.visitor;

import java.text.DecimalFormat;

public class TaxVisitor implements Visitor {
    DecimalFormat df = new DecimalFormat("#.##");

    public TaxVisitor() {
    }

    @Override
    public double visitor(Shirt shirt) {
        System.out.print("Shirt final price with tax: ");
        return Double.parseDouble(df.format(shirt.getPrice() * .18 + shirt.getPrice()));
    }

    @Override
    public double visitor(TShirt tShirt) {
        System.out.print("TShirt final price with tax: ");
        return Double.parseDouble(df.format(tShirt.getPrice() * .20 + tShirt.getPrice()));
    }

    @Override
    public double visitor(Jacket jacket) {
        System.out.print("Jacket final price with tax: ");
        return Double.parseDouble(df.format(jacket.getPrice() * .56 + jacket.getPrice()));
    }
}
