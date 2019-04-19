package com.example.pattern;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.function.UnaryOperator;

public class StrategyPattern {

    public static void main(String[] args) {
        List<Discounter> discounters = Arrays.asList(
                amount -> amount.multiply(BigDecimal.valueOf(0.9)),
                amount -> amount.multiply(BigDecimal.valueOf(0.8)),
                amount -> amount.multiply(BigDecimal.valueOf(0.5))
        );

        Discounter combinedDiscounter = discounters
                .stream()
                .reduce(v -> v, Discounter::combine);

        System.out.println(combinedDiscounter.apply(BigDecimal.valueOf(100)));
    }

    /*public interface Discounter {
        BigDecimal applyDiscount(BigDecimal amount);

        static Discounter christmasDiscounter() {
            return amount -> amount.multiply(BigDecimal.valueOf(0.9));
        }

        static Discounter newYearDiscounter() {
            return amount -> amount.multiply(BigDecimal.valueOf(0.8));
        }

        static Discounter easterDiscounter() {
            return amount -> amount.multiply(BigDecimal.valueOf(0.5));
        }
    }*/

    public interface Discounter extends UnaryOperator<BigDecimal> {
        default Discounter combine(Discounter after) {
            return value -> after.apply(apply(value));
        }
    }
}
