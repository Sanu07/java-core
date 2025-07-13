package com.multithreading.priority;

import java.util.concurrent.BlockingQueue;

public class PriorityBlockingQConsumer implements Runnable {

    BlockingQueue<Integer> q;

    public PriorityBlockingQConsumer(BlockingQueue<Integer> q) {
        this.q = q;
    }

    @Override
    public void run() {
        try {
            System.out.println(q.take());
            Thread.sleep(2000);
            System.out.println(q.take());
            Thread.sleep(2000);
            System.out.println(q.take());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
