package com.multithreading.priority;

import java.util.concurrent.BlockingQueue;

public class PriorityBlockingQProducer implements Runnable {

    BlockingQueue<Integer> q;

    public PriorityBlockingQProducer(BlockingQueue<Integer> q) {
        this.q = q;
    }

    @Override
    public void run() {
        try {
            q.put(5);
            q.put(1);
            Thread.sleep(1000);
            q.put(2);
            Thread.sleep(2000);
            q.put(3);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
