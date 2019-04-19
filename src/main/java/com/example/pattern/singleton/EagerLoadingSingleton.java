package com.example.pattern.singleton;

public class EagerLoadingSingleton {
    private volatile static EagerLoadingSingleton uniqueInstance = new EagerLoadingSingleton();

    private EagerLoadingSingleton() {
    }

    public static EagerLoadingSingleton getInstance() {
        return uniqueInstance;
    }
}
