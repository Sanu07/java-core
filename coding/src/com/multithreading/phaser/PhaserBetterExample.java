package com.multithreading.phaser;

import java.util.concurrent.Phaser;

public class PhaserBetterExample {

    private static final int NUM_WORKERS = 5;

    public static void main(String[] args) {

        Phaser phaser = new Phaser(1); // Register main thread initially

        for (int i = 0; i < 3; i++) {
            int workerId = i;
            phaser.register(); // Register each worker

            new Thread(() -> {
                System.out.println("Worker " + (workerId + 1) + " - Phase 1: Preparing...");
                sleep(2000);
                phaser.arriveAndAwaitAdvance(); // End of Phase 1

                System.out.println("Worker " + (workerId + 1) + " - Phase 2: Processing...");
                sleep(2000);
                phaser.arriveAndAwaitAdvance(); // End of Phase 2

                System.out.println("Worker " + (workerId + 1) + " - Phase 3: Wrapping up...");
                sleep(2000);
                phaser.arriveAndDeregister(); // Done

            }, "Worker-" + (i + 1)).start();
        }

        // Main thread also goes through all phases
        for (int phase = 0; phase < 3; phase++) {
            phaser.arriveAndAwaitAdvance();
            System.out.println("== All workers completed Phase " + (phase + 1) + " ==\n");
        }

        phaser.arriveAndDeregister(); // Main thread done
        System.out.println("Main thread exiting.");
    }

    private static void sleep(long ms) {
        try { Thread.sleep(ms); } catch (InterruptedException e) { e.printStackTrace(); }
    }
}
