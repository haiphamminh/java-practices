package com.example.pattern.singleton;

public class Main {
    public static void main(String[] args) {
        DoubleCheckLockingSingleton singleton = DoubleCheckLockingSingleton.getInstance();
        System.out.println(singleton);
    }
}
