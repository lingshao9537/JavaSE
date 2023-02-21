package com.ling.multithread.PracticeExamples;


/**
 * 睡眠排序
 */
public class SleepSort {
    public static void main(String[] args) throws InterruptedException {

        int[] nums = {98,34,56,2,45,76,89,76,9,12,34,66,55,33,99,76,45,35};
        ThreadTest02[] threadTest02s = new ThreadTest02[nums.length];

        for (int i = 0; i < nums.length; i++) {
            threadTest02s[i] = new ThreadTest02(nums[i]);
        }

        for (int i = nums.length - 1; i >= 0; i--) {
            threadTest02s[i].start();
        }

        new Thread(() -> {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(11);
        }).start();

        new Thread(() -> {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(11);
        }).start();
    }
}

class ThreadTest02 extends Thread {

    public int sleepTime;

    ThreadTest02() {

    }

    ThreadTest02(int sleepTime) {
        this.sleepTime = sleepTime;
    }


    @Override
    public void run() {
        try {
            Thread.sleep(sleepTime);
            System.out.println(sleepTime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
