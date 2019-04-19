package com.example.pattern;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ThreadSafeSingleton {

    public static void main(String[] args) throws InterruptedException {
        final Set<Singleton> set = new HashSet<>();
        ExecutorService es = Executors.newFixedThreadPool(2);
        List<Future<Singleton>> futureList = es.invokeAll(Arrays.asList((Callable<Singleton>) () -> {
            System.out.println(Thread.currentThread().getName() + " Start");
            Singleton inst = Singleton.getInst();
            set.add(inst);
            System.out.println(Thread.currentThread().getName() + " End. inst = " + inst);
            return inst;
        }));

        /*for (int i = 0; i < 2000; i++) {
            es.execute(() -> {
                System.out.println(Thread.currentThread().getName() + " Start");
                DoubleCheckLockingSingleton inst = DoubleCheckLockingSingleton.getInst();
                set.add(inst);
                System.out.println(Thread.currentThread().getName() + " End. inst = " + inst);
            });
        }*/

        es.shutdown();
        while (!es.isTerminated()) { }
        System.out.println("Finished all threads, number of instance: " + set.size());
    }

    public static class Singleton {
        private static Singleton inst;// = new DoubleCheckLockingSingleton();

        private Singleton() {}

        public static Singleton getInst() {
            /*if (inst == null) {
                synchronized (DoubleCheckLockingSingleton.class) {
                    if (inst == null) {
                        inst = new DoubleCheckLockingSingleton();
                    }
                }
            }*/
            if (inst == null) {
                inst = new Singleton();
            }
            return inst;
        }
    }
}
