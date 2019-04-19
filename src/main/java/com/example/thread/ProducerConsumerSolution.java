package com.example.thread;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class ProducerConsumerSolution {
    public static void main(String[] args) {
        BlockingQueue<Integer> sharedQ = new LinkedBlockingQueue<Integer>();
        Producer p = new Producer(sharedQ);
        Consumer c = new Consumer(sharedQ);

        long start = System.currentTimeMillis();
        p.start();
        c.start();
        long end = System.currentTimeMillis();
    }

    static class Producer extends Thread {
        private BlockingQueue<Integer> sharedQueue;

        public Producer(BlockingQueue<Integer> aQueue) {
            super("PRODUCER");
            sharedQueue = aQueue;
        }

        public void run() {
            // no synchronization needed

            for (int i = 0; i < 10; i++) {
                try {
                    System.out.println(getName() + " produced " + i);
                    sharedQueue.put(i);
//                    Thread.sleep(200);
                } catch (InterruptedException e) { e.printStackTrace(); }
            }
        }
    }

    static class Consumer extends Thread {
        private BlockingQueue<Integer> sharedQueue;

        public Consumer(BlockingQueue<Integer> aQueue) {
            super("CONSUMER");
            sharedQueue = aQueue;
        }

        public void run() {
            try {
                while (true) {
                    Integer item = sharedQueue.take();
                    System.out.println(getName() + " consumed " + item);
                }
            } catch (InterruptedException e) { e.printStackTrace(); }
        }
    }

}
