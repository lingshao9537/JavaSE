package com.ling.thread.runnable_02;

/**
 * @Author wanglz
 * @create 2021/12/23 10:34
 */
public class Runnable_01 implements Runnable{

    public static Runnable runnable = null;
    public static int num = 3;

    public boolean flag = false;

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;

    }

    public Runnable_01 () {
        runnable = new Runnable_01();
    }

    @Override
    public void run() {
        if (flag) {
            positive();
        } else {
            negative();
        }
    }

    public void positive() {
        int i = 5;
        while (i > 0) {
            System.out.println(Thread.currentThread() + "_positive: " + num);
            if (num < 0) {
                num = -num;
                System.out.println("positive_after:" + num);
            }
            i--;
        }
    }


    public void negative() {
        int i = 5;
        while (i > 0) {
            System.out.println(Thread.currentThread() + "_negative: " + num);
            if (num > 0) {
                num = -num;
                System.out.println("negative_after:" + num);
            }
            i--;
        }
    }
}
