package com.ling.multithread.waitAndNotify;

public class WaitThread implements Runnable{

    static int num = 0;

    static boolean flag = true;

    @Override
    public void run() {
        while (true) {
            try{
                Thread.sleep(1000);
                String tName = Thread.currentThread().getName();
                loop(tName);
                System.out.println(Thread.currentThread().getName() + "==>线程循环运行");
            } catch (Exception e) {

            }
        }
    }

    private synchronized void loop(String tName) throws Exception{
        if (tName.equals("wtThread1") && num < 5) {
            wait();
        } else if (tName.equals("wtThread2")) {
            if (num > 5 && flag) {
                notify();
                flag = false;
            } else {
                num++;
            }
        }


    }
}
