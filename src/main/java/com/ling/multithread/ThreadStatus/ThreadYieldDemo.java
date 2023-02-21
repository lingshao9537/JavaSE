package com.ling.multithread.ThreadStatus;

public class ThreadYieldDemo {

    public static void main(String[] args) {
        new Thread(new MyYield(), "a").start();
        new Thread(new MyYield(), "b").start();
    }
}

class MyYield implements Runnable {

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "==> 开始执行！");
//        if (Thread.currentThread().getName().equals("a")) {
//            Thread.yield();
//        }
        Thread.yield();
        System.out.println(Thread.currentThread().getName() + "==> 结束执行！");
    }
}
