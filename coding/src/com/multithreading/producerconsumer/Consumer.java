package com.multithreading.producerconsumer;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.BlockingQueue;

public class Consumer implements Runnable {

    private final BlockingQueue<Integer> sharedQueue;

    public Consumer(BlockingQueue<Integer> queue) {
        this.sharedQueue = queue;
    }

    @Override
    public void run() {
        try {
            while (true) {
                Integer elem = sharedQueue.take();
                System.out.println("Consumed -> " + elem);
                Thread.sleep(2000);
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
