package com.example;

public class Operators {

    public static void main(String[] args) {
        int a = 0b0011_1100;

        int b = 0b0000_1101;

        System.out.println(Integer.toBinaryString(5));
        System.out.println("a&b: " + (a & b) + " -> " + Integer.toBinaryString(a & b)); // = 0000 1100
        System.out.println("a|b: " + (a | b) + " -> " + Integer.toBinaryString(a | b)); // = 0011 1101
        System.out.println("a^b: " + (a ^ b) + " -> " + Integer.toBinaryString(a ^ b)); // = 0011 0001
        System.out.println("~a: " + (~a) + " -> " + Integer.toBinaryString(~a)); // = 1100 0011
    }
}
