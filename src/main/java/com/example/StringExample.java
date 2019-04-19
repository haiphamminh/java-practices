package com.example;

import static com.example.AddressPrinterUtil.addressOf;

public class StringExample {
    public static void main(String[] args) {
        String str1 = "abc";
        String str2 = "abc";

        String str3 = new String("abc");
        String str4 = new String("abc");

        System.out.println(Integer.toHexString(str1.hashCode()));
        System.out.println(Integer.toHexString(str2.hashCode()));
        System.out.println(Integer.toHexString(str3.hashCode()));
        System.out.println(Integer.toHexString(str4.hashCode()));

        System.out.println(System.identityHashCode(str1));
        System.out.println(System.identityHashCode(str2));
        System.out.println(System.identityHashCode(str3));
        System.out.println(System.identityHashCode(str4));

        System.out.println("str1 == str2 -> " + (str1 == str2));
        System.out.println("str3 == str4 -> " + (str3 == str4));
        System.out.println("str1 == str4 -> " + (str1 == str4));
        System.out.println("str1.equals(str4) -> " + str1.equals(str4));
        System.out.println("str3.equals(str4) -> " + str3.equals(str4));
        System.out.println("str1.intern() -> " + str1.intern());
        System.out.println("str3.intern() -> " + str3.intern());

        addressOf(str1);
        addressOf(str2);
        addressOf(str3);
        addressOf(str4);

    }
}
