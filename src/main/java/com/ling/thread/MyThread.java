package com.ling.thread;

/**
 * @Author wanglz
 * @create 2021/12/15 14:56
 */
public class MyThread extends Thread{

    public static Integer A = 30;
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + ":" + A--);
    }

    public static void main(String[] args) {
        new MyThread().start();
        new MyThread().start();
        new MyThread().start();

        try{
            sleep(1000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(MyThread.A);

    }
}
