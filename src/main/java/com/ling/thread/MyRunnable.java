package com.ling.thread;

/**
 * @Author wanglz
 * @create 2021/12/15 14:58
 */
public class MyRunnable implements Runnable{
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
    }
}
