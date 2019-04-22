package com.example.pattern.prototype;

public class Dolphin implements Prototype {
    private String name;
    private int age;

    public Dolphin(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public Prototype clone() {
        return new Dolphin(name, age);
    }
}
