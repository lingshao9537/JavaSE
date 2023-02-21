package com.ling.multithread;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class AtguiguMultithread {
    public static void main(String[] args) {
        /**
         * 创建线程的第一种方法，就是继承Thread类，调start方法启动run
         */
//        Thread m1 = new MyThread1();
//        m1.setName("Thread线程一");
//        m1.start();
//        Thread m2 = new MyThread1();
//        m2.setName("Thread线程二");
//        m2.start();
        /**
         * 创建线程第二种方法:就是实现Runnable接口，创建对象将其作为Thread类有参构造函数的参数，调用start方法启动run
         */
//        new Thread(new MyThread2(),"线程一").start();
//        new Thread(new MyThread2(),"线程二").start();

        Thread t1 = new Thread(new Ticket(),"t1窗口");
        Thread t2 = new Thread(new Ticket(),"t2窗口");
        Thread t3 = new Thread(new Ticket(),"t3窗口");

        t1.start();
        t2.start();
        t3.start();
//        Thread t1 = new TicketThread();
//        Thread t2 = new TicketThread();
//        Thread t3 = new TicketThread();
//        t1.start();
//        t2.start();
//        t3.start();

    }
}

class MyThread1 extends Thread{
    static int i = 10;
    @Override
    public void run() {
        for (; i > 0 ; i--){
            System.out.println(Thread.currentThread().getName()+"售票第"+i+"张");
        }
    }
}

class MyThread2 implements Runnable{
    static int i = 10;
    @Override
    public synchronized void run() {
        for (; i > 0 ; i--){
            System.out.println(Thread.currentThread().getName()+"售票第"+i+"张");
        }
    }
}
class TicketThread extends Thread{
    private  static int tick = 100;
    Set set = new HashSet();
    List list = new ArrayList<>();
    @Override
    public synchronized void  run() {
        while (true) {
            if (tick > 0) {
                set.add(String.valueOf(tick));
                list.add(tick);
                System.out.println(Thread.currentThread().getName() + "售出车票，tick号为：" + tick--);
            } else
                break;
        }
        System.out.println("set的容量："+set.size());
        System.out.println("list的容量："+list.size());
    }
}


class Ticket implements Runnable{
    private  static int tick = 100;
    Set set = new HashSet();
    @Override
    public synchronized void  run() {
        while (true) {
            if (tick > 0) {
                set.add(String.valueOf(tick--));
                System.out.println(Thread.currentThread().getName() + "售出车票，tick号为：" + tick);
            } else {
                break;
            }
        }
        System.out.println(set.size());
    }
}