package com.ling.thread;

/**
 * @Author wanglz
 * @create 2021/12/15 14:55
 */
public class ThreadDemo {

    public static void main(String[] args) throws InterruptedException {

        MyThread myThread = new MyThread();
        myThread.start();

        Thread thread = new Thread(myThread);
        thread.start();

        Thread thread1 = new Thread() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + "a");
            }
        };
        thread1.start();

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + "b");
            }
        };
        new Thread(runnable).start();


        System.out.println(Thread.currentThread().getName());
    }
}
