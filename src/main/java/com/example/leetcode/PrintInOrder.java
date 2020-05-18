// https://leetcode.com/problems/print-in-order/

package com.example.leetcode;

import java.util.concurrent.CountDownLatch;

public class PrintInOrder {

    private final CountDownLatch firstCountDownLatch;
    private final CountDownLatch secondCountDownLatch;

    public PrintInOrder() {
        firstCountDownLatch = new CountDownLatch(1);
        secondCountDownLatch = new CountDownLatch(1);
    }

    public void first(Runnable printFirst) throws InterruptedException {
        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        firstCountDownLatch.countDown();
    }

    public void second(Runnable printSecond) throws InterruptedException {
        firstCountDownLatch.await();
        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();
        secondCountDownLatch.countDown();
    }

    public void third(Runnable printThird) throws InterruptedException {
        secondCountDownLatch.await();
        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();
    }

    public static void main(String[] args) throws InterruptedException {
        final PrintInOrder f = new PrintInOrder();
        Thread t1 = new Thread(() -> {
            try {
                f.third(() -> {
                    System.out.print("third");
                });
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        t1.start();
        Thread t2 = new Thread(() -> {
            try {
                f.second(() -> {
                    System.out.print("second");
                });
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        t2.start();
        Thread t3 = new Thread(() -> {
            try {
                f.first(() -> {
                    System.out.print("first");
                });
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        t3.start();
    }
}
