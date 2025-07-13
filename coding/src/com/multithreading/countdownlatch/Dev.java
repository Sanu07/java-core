package com.multithreading.countdownlatch;

import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class Dev implements Runnable {

    private CountDownLatch countDownLatch;
    private String name;

    public Dev(CountDownLatch countDownLatch, String name) {
        this.countDownLatch = countDownLatch;
        this.name = name;
    }

    @Override
    public void run() {
        try {
            TimeUnit.SECONDS.sleep(new Random().nextInt(10) + 1);
            System.out.println("Dev Team - " + this.name + " completed");
        } catch (InterruptedException e) {

        } finally {
            countDownLatch.countDown();
        }
    }
}
