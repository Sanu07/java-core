package com.multithreading.deadlock;

import java.util.concurrent.TimeUnit;

public class Deadlock {

    private final Object lock1 = new Object();
    private final Object lock2 = new Object();

    public static void main(String[] args) {
        Deadlock deadlock = new Deadlock();
        // deadlock.deadlock();
        deadlock.noDeadlock();
    }

    private void deadlock() {
        Thread t1 = new Thread(this::worker1, "thread::1");
        Thread t2 = new Thread(this::worker2, "thread::2");
        t1.start();
        t2.start();
    }

    private void noDeadlock() {
        Thread t1 = new Thread(this::worker1, "thread::1");
        Thread t3 = new Thread(this::worker3, "thread::3");
        t1.start();
        t3.start();
    }

    private void worker1() {
        synchronized (lock1) {
            System.out.println("acquired lock on 1 ----> " + Thread.currentThread().getName());
            try {
                TimeUnit.SECONDS.sleep(2);
                synchronized (lock2) {
                    System.out.println("acquired lock on 2 ----> " + Thread.currentThread().getName());
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private void worker2() {
        synchronized (lock2) {
            System.out.println("acquired lock on 2 ----> " + Thread.currentThread().getName());
            try {
                TimeUnit.SECONDS.sleep(2);
                synchronized (lock1) {
                    System.out.println("acquired lock on 1 ----> " + Thread.currentThread().getName());
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private void worker3() {
        synchronized (lock1) {
            System.out.println("acquired lock on 1 ----> " + Thread.currentThread().getName());
            try {
                TimeUnit.SECONDS.sleep(2);
                synchronized (lock2) {
                    System.out.println("acquired lock on 2 ----> " + Thread.currentThread().getName());
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
