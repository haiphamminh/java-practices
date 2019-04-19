package com.example;

import java.lang.reflect.Field;

import sun.misc.Unsafe;

public class AddressPrinterUtil {
    private static Unsafe unsafe;

    static {
        try {
            Field field = Unsafe.class.getDeclaredField("theUnsafe");
            field.setAccessible(true);
            unsafe = (Unsafe) field.get(null);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void printAddress(Object obj) {
        System.out.println(System.identityHashCode(obj));
    }

    public static long addressOf(Object o) {
        Object[] array = new Object[] { o };

        long baseOffset = unsafe.arrayBaseOffset(Object[].class);
        int addressSize = unsafe.addressSize();
        long objectAddress;
        switch (addressSize) {
            case 4:
                objectAddress = unsafe.getInt(array, baseOffset);
                break;
            case 8:
                objectAddress = unsafe.getLong(array, baseOffset);
                break;
            default:
                throw new Error("unsupported address size: " + addressSize);
        }
        System.out.println(String.format("0x%d", objectAddress));
        return objectAddress;
    }
}
