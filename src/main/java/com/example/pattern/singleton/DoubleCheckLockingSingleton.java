package com.example.pattern.singleton;

public class DoubleCheckLockingSingleton {
    private volatile static DoubleCheckLockingSingleton uniqueInstance;

    private DoubleCheckLockingSingleton() {
    }

    public static DoubleCheckLockingSingleton getInstance() {
        if (uniqueInstance == null) {
            synchronized (DoubleCheckLockingSingleton.class) {
                if (uniqueInstance == null) {
                    uniqueInstance = new DoubleCheckLockingSingleton();
                }
            }
        }
        return uniqueInstance;
    }
}