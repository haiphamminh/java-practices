package com.example.immutable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ImmutableTest {

    public static void main(String[] args) {
        immutableCityTest();
        immutableFoodListTest();
    }

    public static void immutableCityTest() {
        ImmutablePerson immutablePerson = ImmutablePerson.builder()
                                                         .withName("Viktor")
                                                         .withCity("Stockholm")
                                                         .withFavoriteDishes(
                                                                 Arrays.asList("Pizza", "Tacos", "Steak"))
                                                         .build();

        new Thread(() -> {
            try {
                Thread.sleep(5); // Simulate some work
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            immutablePerson.toBuilder()
                           .withCity("Gothenburg")
                           .build();
        }).start();

        if ("Stockholm".equals(immutablePerson.getCity())) {
            try {
                Thread.sleep(10); // Simulate some work
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Viktor lives in " + immutablePerson.getCity());
        }
    }

    public static void immutableFoodListTest() {
        List dishes = new ArrayList<>();
        dishes.add("Pizza");
        dishes.add("Tacos");
        dishes.add("Steak");

        ImmutablePerson immutablePerson1 = ImmutablePerson.builder()
                                                          .withName("Viktor")
                                                          .withCity("Stockholm")
                                                          .withFavoriteDishes(dishes)
                                                          .build();

        List dishes2 = immutablePerson1.getFavoriteDishes();
        dishes2.add("Sushi");

        ImmutablePerson immutablePerson2 = ImmutablePerson.builder()
                                                          .withName("Anastasia")
                                                          .withCity("Stockholm")
                                                          .withFavoriteDishes(dishes2)
                                                          .build();

        for (String dish : immutablePerson1.getFavoriteDishes()) {
            System.out.println(dish);
        }
    }
}
