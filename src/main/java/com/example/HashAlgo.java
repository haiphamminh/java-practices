package com.example;

public class HashAlgo {
    public static void main(String[] args) {
        char val[] = { 'm', 'e', 's', 's', 'a', 'g', 'e', 'm', 'e', 'd', 'i', 'a' };
        int h = 0;
        for (int i = 0; i < val.length; i++) {
            h = 31 * h + val[i];
            System.out.println("char: " + val[i] + "; hash: " + h);
        }
        System.out.println(h);

        System.out.println(hash(546546546));
    }

    private static int hash(int hashKey) {
        System.out.println(hashKey >>> 16);
        return hashKey ^ (hashKey >>> 16);
    }
}
