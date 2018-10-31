package com.kryocore.common.Latch;

public class LatchTest {
    public static void main(String[] args) throws InterruptedException{
        Latch latch = new CountDownLatch(4);
        new ProgrammerTravel(latch,"Alex","Bus").start();
        new ProgrammerTravel(latch,"Alex2","Walking").start();
        new ProgrammerTravel(latch,"Alex3","Subway").start();
        new ProgrammerTravel(latch,"Alex4","Bicycle").start();
        latch.await();
        System.out.println("=== all of programmer arrived ===");
    }
}
