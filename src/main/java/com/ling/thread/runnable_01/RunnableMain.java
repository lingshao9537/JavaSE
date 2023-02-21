package com.ling.thread.runnable_01;

import com.ling.thread.MyThread;

/**
 * @Author wanglz
 * @create 2021/12/15 15:09
 */
public class RunnableMain {

    public static void main(String[] args) {

        Runnable runnable = new RunnableDemo();
        new Thread(runnable).start();
        new Thread(runnable).start();
        new Thread(runnable).start();


        Thread myThread = new MyThread();
        myThread.start();



        try {
            Thread.sleep(1000);
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println(Thread.currentThread().getState());

    }
}
