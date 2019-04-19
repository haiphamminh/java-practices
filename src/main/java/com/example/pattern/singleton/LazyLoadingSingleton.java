package com.example.pattern.singleton;

public class LazyLoadingSingleton {
    private volatile static LazyLoadingSingleton uniqueInstance;

    private LazyLoadingSingleton() {
    }

    public static LazyLoadingSingleton getInstance() {
        if (uniqueInstance == null) {
            uniqueInstance = new LazyLoadingSingleton();
        }
        return uniqueInstance;
    }
}
