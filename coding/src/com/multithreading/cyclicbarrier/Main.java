package com.multithreading.cyclicbarrier;

import java.util.concurrent.CyclicBarrier;

public class Main {

    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(4);
        Passenger p1 = new Passenger(cyclicBarrier, "p1");
        Passenger p2 = new Passenger(cyclicBarrier, "p2");
        Passenger p3 = new Passenger(cyclicBarrier, "p3");
        Passenger p4 = new Passenger(cyclicBarrier, "p4");

        Passenger p5 = new Passenger(cyclicBarrier, "p5");
        Passenger p6 = new Passenger(cyclicBarrier, "p6");
        Passenger p7 = new Passenger(cyclicBarrier, "p7");
        Passenger p8 = new Passenger(cyclicBarrier, "p8");

        Thread t1 = new Thread(p1);
        Thread t2 = new Thread(p2);
        Thread t3 = new Thread(p3);
        Thread t4 = new Thread(p4);
        Thread t5 = new Thread(p5);
        Thread t6 = new Thread(p6);
        Thread t7 = new Thread(p7);
        Thread t8 = new Thread(p8);

        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
        t6.start();
        t7.start();
        t8.start();
    }
}
