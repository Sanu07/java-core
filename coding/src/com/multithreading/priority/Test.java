package com.multithreading.priority;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;

public class Test {

    public static void main(String[] args) {

        BlockingQueue<Integer> q = new PriorityBlockingQueue<>();

        PriorityBlockingQProducer producer = new PriorityBlockingQProducer(q);
        PriorityBlockingQConsumer consumer = new PriorityBlockingQConsumer(q);

        Thread t1 = new Thread(producer);
        Thread t2 = new Thread(consumer);

        t1.start();
        t2.start();
    }
}
