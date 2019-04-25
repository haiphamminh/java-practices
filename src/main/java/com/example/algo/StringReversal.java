package com.example.algo;

public class StringReversal {
    public static void main(String[] args) {
        System.out.println(reverse("hello"));
    }

    static String reverse(String input) {
        StringBuilder sb = new StringBuilder(input);
        return sb.reverse().toString();
    }
}
