package com.ling.designMode.SimpleFactory;

import java.util.Scanner;

/**
 * @Author wanglz
 * @create 2022/3/5 15:56
 *
 * 面向对象语言实现一个计算机控制台程序，要求输入两个数和运算符号，得到结果
 */

public class SimpleFactoryDemo {
    public static void main(String[] args) {
        System.out.print("请输入数字A：");
        Scanner sc1 = new Scanner(System.in);
        sc1.nextDouble();

        System.out.print("请输入数字B：");
        Scanner sc2 = new Scanner(System.in);
        sc2.nextDouble();

        System.out.println("请输入运算符：");
        Scanner sc3 = new Scanner(System.in);
        sc3.next();


    }
}



