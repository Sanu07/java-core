package com.multithreading;

public class Multi1 {


    private static final Object lock = new Object();

    private static int counter = 0;

    public static void main(String[] args) {
        Thread t1 = new Thread(Multi1::worker1, "Thread-1");
        Thread t2 = new Thread(Multi1::worker2, "Thread-2");

        t1.start();
        t2.start();
    }

    public static void worker1() {
        synchronized (lock) {
            counter++;
        }
    }

    public static void worker2() {
        synchronized (lock) {
            counter++;
        }
    }
}
