package com.multithreading.phaser;

import java.util.concurrent.Phaser;
import java.util.concurrent.TimeUnit;

public class CountdownPhaser implements Runnable {

    private Phaser phaser;
    private String name;

    public CountdownPhaser(Phaser phaser, String name) {
        this.phaser = phaser;
        this.name = name;
    }

    @Override
    public void run() {
        System.out.println("working..... " + this.name);
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {


        }
        phaser.arrive();
        System.out.println("arrived parties -> " + phaser.getArrivedParties());
    }
}
