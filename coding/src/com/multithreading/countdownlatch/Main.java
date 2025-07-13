package com.multithreading.countdownlatch;

import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) {
        CountDownLatch devCountdownLatch = new CountDownLatch(2);

        Dev devTeamA = new Dev(devCountdownLatch, "A");
        Dev devTeamB = new Dev(devCountdownLatch, "B");

        QA qa = new QA("QA");

        Thread t1 = new Thread(devTeamA);
        Thread t2 = new Thread(devTeamB);
        t1.start();
        t2.start();

        try {
            devCountdownLatch.await(20, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
        }

        Thread t3 = new Thread(qa);
        t3.start();
    }
}
