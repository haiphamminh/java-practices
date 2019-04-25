package com.example.hackerrank;

public class Staircase {
    public static void main(String[] args) {
        staircase(6);
    }

    static void staircase(int n) {
        for (int j = 0; j < n; j++) {
            for (int i = 1; i <= n; i++) {
                System.out.print(i < n - j ? " " : "#");
            }
            System.out.println();
        }
    }
}
