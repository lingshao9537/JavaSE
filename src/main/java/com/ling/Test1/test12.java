package com.ling.Test1;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.Map;

public class test12 {
    public static void main(String[] args) {
        String i = "HelloHello";
        final String i1 = "Hello";
        String i2 = "Hello";
        String i3 = i1 + i2;//只要进行了+ 操作，就是new了一个StringBuffer对象，调用了append方法。

        System.out.println(i1 == i2);
        System.out.println(i == i3);
        System.out.println(i == i1+i2);
        System.out.println(i == i1 +"Hello");

        System.out.println("=======================");

        Integer A1 = 7;
        Integer A2 = 3;
        Double A3 = Double.valueOf(A1)/A2;
        Double A4 = Double.valueOf(A1 + A2)/A2;
        Map<String, Object> eeMap = new HashMap<>();
        eeMap.put("A3", A3);
        System.out.println("A3:" + eeMap.get("A3"));
        eeMap.put("A4", A4);
        System.out.println("A4:" + eeMap.get("A4"));
        eeMap.put("A3+A4", A3 + A4);
        System.out.println("A3+A4:" + eeMap.get("A3+A4"));
        System.out.println("========================>");
        System.out.println(A1 + " / " + A2 + " = " + (A1%A2 > 0 ? A1/A2 + 1 : A1/A2));
        System.out.println(A3);
        System.out.println(A1 + " / " + A2 + " = " + Math.ceil((double) A1/A2));

        String A32 = "123123-123";
        System.out.println(A32.substring(0, A32.indexOf("-")) + ", " + A32.indexOf("-"));


        System.out.println("=================================");

        Map<String, Object> testMap = new HashMap<>();
        testMap.put("A32", A32);
        testMap.put("A3", A3);
        System.out.println("A32："+testMap.get("A32") + ", A3:" + testMap.get("A3"));


        System.out.println("==============");
        double dou = 3.1487426;
        BigDecimal bigDecimal = new BigDecimal(dou).setScale(2, RoundingMode.HALF_UP);
        double newDouble = bigDecimal.doubleValue();
        System.out.println(newDouble);


        Integer a11 = 3;
        Integer f = 5;
        Integer re = a11 % 5 > 0 ? a11 / 5 + 1 : a11 / 5;

        System.out.println(re);

    }

}
