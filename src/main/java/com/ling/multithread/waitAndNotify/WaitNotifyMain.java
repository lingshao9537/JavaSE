package com.ling.multithread.waitAndNotify;

public class WaitNotifyMain {

    public static void main(String[] args) {


        Thread wtThread1 = new Thread(new WaitThread(), "wtThread1");
        Thread wtThread2 = new Thread(new WaitThread(), "wtThread2");


        wtThread1.start();
        wtThread2.start();

    }
}
