package com.multithreading.cyclicbarrier;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;

public class Passenger implements Runnable {

    private final CyclicBarrier cyclicBarrier;
    private final String name;

    public Passenger(CyclicBarrier cyclicBarrier, String name) {
        this.cyclicBarrier = cyclicBarrier;
        this.name = name;
    }

    @Override
    public void run() {
        try {
            TimeUnit.SECONDS.sleep(new Random().nextInt(5) + 1);
            System.out.println(this.name + " has arrived");
            try {
                int await = cyclicBarrier.await();
                if (await == 0) {
                    System.out.println("Four passengers have arrived. Lets go!!");
                    TimeUnit.SECONDS.sleep(2);
                }
            } catch (BrokenBarrierException e) {
                throw new RuntimeException(e);
            }
        } catch (InterruptedException e) {}
    }
}
