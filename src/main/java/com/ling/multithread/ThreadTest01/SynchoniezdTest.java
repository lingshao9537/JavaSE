package com.ling.multithread.ThreadTest01;

import com.ling.multithread.waitAndNotify.WaitThread;

public class SynchoniezdTest implements Runnable{

    WaitThread waitThread = new WaitThread();

    @Override
    public void run() {
        while (true) {
            try{

                Thread.sleep(100);
                printNo();
//                print();
            } catch (Exception e) {

            }

        }
    }

    private void print() {
        System.out.println(Thread.currentThread().getName() + ":  被锁方法1");
        System.out.println(Thread.currentThread().getName() + ":  被锁方法2");
        System.out.println(Thread.currentThread().getName() + ":  被锁方法3");
    }

    private void printNo() {

        System.out.println(Thread.currentThread().getName() + ":  锁前----》 无锁代码块");
        synchronized (waitThread) {
            System.out.println(Thread.currentThread().getName() + ":  被锁代码块");
        }
        // 因为前面被锁，所以后面也会被锁 这就是所谓的流程
        System.out.println(Thread.currentThread().getName() + ":  锁后---》 无锁代码块");

    }


    public static void main(String[] args) {
//        new Thread(new SynchoniezdTest(), "syncThread1").start();
//        new Thread(new SynchoniezdTest(), "syncThread2").start();

        System.out.println(System.currentTimeMillis());

        System.out.println("h264".equalsIgnoreCase("h264"));



    }
}
