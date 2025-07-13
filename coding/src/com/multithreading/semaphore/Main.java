package com.multithreading.semaphore;

import java.util.concurrent.Semaphore;

public class Main {

    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(3);

        for (int i = 0; i < 20; i++) {
            AtmMachine atmMachine = new AtmMachine(semaphore, "P" + (i + 1));
            Thread t1 = new Thread(atmMachine);
            t1.start();
        }
    }
}
