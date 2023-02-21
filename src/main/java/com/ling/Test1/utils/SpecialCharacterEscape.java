package com.ling.Test1.utils;

import com.google.common.collect.Lists;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SpecialCharacterEscape {

    public static void main(String[] args) {
        String flg = "1'1'1'1'1'1'1'1";
        String s = new SpecialCharacterEscape().characterEscape(flg);
        System.out.println(s);
        System.out.println(flg);

        String[] split = "12,*34,*5".split("\\*");
        System.out.println(split.length);
        for (String s1: split) {
            System.out.println(s1);
        }
        System.out.println();


        Map<String, Object> sk = new HashMap<>();
        List<String> er = Lists.newArrayList("1","2");
        List<String> et = Lists.newArrayList();
        List<String> ey = null;

        sk.put("er", er);
        sk.put("et", et);
        sk.put("ey", ey);

        List<String> df = (List<String>) sk.get("121");
        if (null == df || df.size() > 0) {

        }

//        List<Map<String, Object>> ls = new ArrayList<>();
//        Map<String, Object> dsd = null;
//        ls.add(dsd);
//        for (Map<String, Object> d : ls) {
//            List<String> dg = (List<String>) d.get("dsds");
//            if (null == dg || dg.size() == 0) {
//                System.out.println("1111");
//            }
//        }

        System.out.println(System.getProperty("user.dir"));
        File file = new File(System.getProperty("user.dir")  + File.pathSeparator + "energy/111.txt");

        int i = 0;
        while (i <= 10) {
            System.out.println("随机数：");
            System.out.println(Math.round(Math.random() * 10));
            i++;
        }
    }

    public String characterEscape(String flg) {
        return flg.replaceAll("'", "''");
    }
}
