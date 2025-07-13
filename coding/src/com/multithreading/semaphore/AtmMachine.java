package com.multithreading.semaphore;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class AtmMachine implements Runnable {

    private final Semaphore semaphore;
    private final String name;

    public AtmMachine(Semaphore semaphore, String name) {
        this.semaphore = semaphore;
        this.name = name;
    }

    @Override
    public void run() {
        try {
            semaphore.acquire();
            System.out.println("permit acquired :: " + this.name);
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            semaphore.release();
        }
    }
}
