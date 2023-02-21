package com.ling.thread.runnable_01;

/**
 * @Author wanglz
 * @create 2021/12/15 15:07
 */
public class RunnableDemo implements Runnable{
    public int i = 10;

    @Override
    public void run() {
        sell();
    }

    public void sell() {
        while (i > 0) {
            synchronized (this) {
                if (i < 1) {
                    return;
                }
                System.out.println("线程" + Thread.currentThread().getName() + "执行到" + i--);
            }
        }

        System.out.println("线程" + Thread.currentThread().getName() + "执行完了");
//        try{
//            Thread.sleep(200);
//        } catch (InterruptedException  e) {
//            e.printStackTrace();
//        }
    }
}
