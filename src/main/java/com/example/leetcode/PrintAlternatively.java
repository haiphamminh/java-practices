// https://leetcode.com/problems/print-foobar-alternately/

package com.example.leetcode;

public class PrintAlternatively {
    private final int n;
    private volatile int barrier = 0;

    public PrintAlternatively(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            while (barrier != 0) {
                Thread.yield();
            }
            // printFoo.run() outputs "foo". Do not change or remove this line.
            printFoo.run();
            ++barrier;
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            while (barrier != 1) {
                Thread.yield();
            }
            // printBar.run() outputs "bar". Do not change or remove this line.
            printBar.run();
            --barrier;
        }
    }

    public static void main(String[] args) {
        final PrintAlternatively printAlternatively = new PrintAlternatively(2);
        Thread t1 = new Thread(() -> {
            try {
                printAlternatively.foo(() -> {
                    System.out.print("foo");
                });
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        t1.start();
        Thread t2 = new Thread(() -> {
            try {
                printAlternatively.bar(() -> {
                    System.out.print("bar");
                });
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        t2.start();
    }
}
