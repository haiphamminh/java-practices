package com.example;

import static com.example.AddressPrinterUtil.addressOf;

public class ParameterPassByValue {
    public static void main(String[] args) {
        Test t = new Test("abc");
        System.out.println(t);
        System.out.print("t outside test(): ");
        addressOf(t);

        test(t);

        System.out.println(t);
        System.out.print("t after called test(): ");
        addressOf(t);

        int a = 6;
        testPrimitiveParam(a);
        System.out.println(a);
    }

    public static void testPrimitiveParam(int a) {
        a = 4;
    }

    public static void test(Test t) {
        System.out.println(t);
        System.out.print("t inside test(): ");
        addressOf(t);
        Test t1 = new Test("xyz");
        t = t1;
        t.setS("gfdg");
        System.out.println(t);
        System.out.print("t after created with 'new': ");
        addressOf(t);
    }

    private static class Test {
        private String s;

        public Test(String s) {
            this.s = s;
        }

        public void setS(String s) {
            this.s = s;
        }

        @Override
        public String toString() {
            return s;
        }
    }
}
