package com.ling.thread.runnable_02;

import java.util.HashMap;

/**
 * @Author wanglz
 * @create 2021/12/23 10:39
 */
public class RunnableImpl {

    public static void main(String[] args) {
        Runnable runnable = new Runnable_01();
        new Thread();

        try{
            Thread.sleep(1000);
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println(Thread.currentThread().getName() + ": " + Runnable_01.num);


    }


}
