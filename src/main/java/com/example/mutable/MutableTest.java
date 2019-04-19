package com.example.mutable;

import java.util.Arrays;

public class MutableTest {

    public static void main(String[] args) {
        mutableCityTest();
    }

    public static void mutableCityTest() {
        MutablePerson mutablePerson = new MutablePerson("Viktor", "Stockholm", Arrays
                .asList("Pizza", "Tacos", "Steak"));

        new Thread(() -> {
            try {
                Thread.sleep(5); // Simulate some work
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            mutablePerson.setCity("Gothenburg");
        }).start();

        if ("Stockholm".equals(mutablePerson.getCity())) {
            try {
                Thread.sleep(10); // Simulate some work
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Viktor lives in " + mutablePerson.getCity());
        }
    }
}
