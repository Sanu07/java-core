package com.multithreading.phaser;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Phaser;

public class PhaserMain {

    public static void main(String[] args) {
        Phaser phaser = new Phaser(20);

        for (int i = 0; i < 20; i++) {
            Thread t1 = new Thread(new CountdownPhaser(phaser, "P" + (i + 1)));
            t1.start();
        }

        phaser.awaitAdvance(20);

        System.out.println("QA work starting");
    }
}
