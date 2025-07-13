package com.multithreading.producerconsumer;

import java.util.concurrent.BlockingQueue;

public class Producer implements Runnable {

    private final BlockingQueue<Integer> sharedQueue;

    public Producer(BlockingQueue<Integer> queue) {
        this.sharedQueue = queue;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 20; i++) {
            try {
                System.out.println("Produced " + i);
                sharedQueue.put(i);
                Thread.sleep(1500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
