package com.ling.multithread.PracticeExamples;

/**
 * 火车票出售
 */

public class TicketSellThread {
    public static void main(String[] args) {
        new Thread(new TicketSellWindows_01(), "1号窗口").start();
        new Thread(new TicketSellWindows_01(), "2号窗口").start();
        new Thread(new TicketSellWindows_01(), "3号窗口").start();
        new Thread(new TicketSellWindows_01(), "4号窗口").start();


    }

}

class TicketNum {
    public static Integer num = 80;
}

class TicketSellWindows_01 implements Runnable{

    @Override
    public void run() {
        while (true) {
            if (TicketNum.num < 1) {
                return;
            }
            synchronized (TicketNum.num) {
                System.out.println(Thread.currentThread().getName() + "售票" + TicketNum.num--);
            }
        }

    }
}

