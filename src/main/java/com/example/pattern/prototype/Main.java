package com.example.pattern.prototype;

public class Main {
    public static void main(String[] args) {
        Person david = new Person("David", 23);
        System.out.println("David: " + david);

        Person john = (Person) david.clone();
        john.setName("John");
        john.setAge(32);
        System.out.println("John: " + john);
    }
}
