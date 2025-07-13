package com.multithreading.countdownlatch;

import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class QA implements Runnable {

    private final String name;

    public QA(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        try {
            TimeUnit.SECONDS.sleep(new Random().nextInt(5) + 1);
            System.out.println("QA Team - " + this.name + " completed");
        } catch (InterruptedException e) {

        }
    }
}
