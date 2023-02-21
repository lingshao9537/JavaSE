package com.ling.multithread.PracticeExamples;

/**
 * 龟兔赛跑
 */

public class TortoiseAndRabbitRace {
    public static void main(String[] args) {


    }


}

class Race implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName() + "=====" + i);
        }
    }

    private boolean gameover() {
        return false;
    }
}


