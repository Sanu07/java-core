package com.multithreading.delayqueue;

import java.util.concurrent.DelayQueue;

public class Test {

    public static void main(String[] args) {
        DelayQueue<DelayMessage> queue = new DelayQueue<>();
        new Thread(() -> {
            queue.put(new DelayMessage("Message 1 (2s delay)", 2000));
            queue.put(new DelayMessage("Message 2 (4s delay)", 4000));
            queue.put(new DelayMessage("Message 3 (1s delay)", 1000));
            System.out.println("All messages added to queue.");
        }).start();

        new Thread(() -> {
            try {
                while (true) {
                    DelayMessage message = queue.take(); // waits until delay expires
                    System.out.println("[" + System.currentTimeMillis() + "] Consumed: " + message.getMessage());
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }).start();
    }
}
