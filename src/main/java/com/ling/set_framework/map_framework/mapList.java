package com.ling.set_framework.map_framework;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author wanglz
 * @create 2021/7/21 14:44
 */
public class mapList {

    public static void main(String[] args) {

        Map<String, List<Map<String, Object>>> costMap = new HashMap<>();


        Map<String, List<Map<String, Object>>> costMap1 = new HashMap<>();

        List<Map<String, Object>> list1 = new ArrayList<>();
        List<Map<String, Object>> list2 = new ArrayList<>();
        List<Map<String, Object>> list3 = new ArrayList<>();

        Map<String, Object> map1 = new HashMap<>();
        Map<String, Object> map2 = new HashMap<>();
        Map<String, Object> map3 = new HashMap<>();
        Map<String, Object> map4 = new HashMap<>();
        Map<String, Object> map5 = new HashMap<>();
        Map<String, Object> map6 = new HashMap<>();

        map1.put("list1", "list1");
        map1.put("code", "A");
        map2.put("list3", "list2");
        map2.put("code", "B");
        map3.put("list5", "list3");
        map3.put("code", "B");
        map4.put("list7", "list4");
        map4.put("code", "A");
        map5.put("list9", "list5");
        map5.put("list10", "list5");
        map6.put("list11", "list6");
        map6.put("list12", "list6");

        list1.add(map1);
        list1.add(map2);
        list1.add(map3);
        list1.add(map4);
        list3.add(map5);
        list3.add(map6);

        costMap1.put("listMap1", list1);
        costMap1.put("listMap2", list2);
        costMap1.put("listMap3", list3);


        list1.forEach(map -> {
            if (costMap.containsKey(map.get("code"))) {
                costMap.get(map.get("code")).add(map);
            } else {
                List<Map<String, Object>> costList = new ArrayList<>();
                costList.add(map);
                costMap.put(map.get("code").toString(), costList);
            }
        });

        System.out.println(costMap);


        BigDecimal a = BigDecimal.ONE;
        System.out.println(a);
        BigDecimal b = new BigDecimal(String.valueOf(a));
        a = new BigDecimal(String.valueOf(b));
        System.out.println(a);


        List<BigDecimal> list = new ArrayList<>();
        list.add(new BigDecimal("1"));
        list.add(new BigDecimal("2"));
        list.add(new BigDecimal("3"));

        BigDecimal re = new BigDecimal("21");


        System.out.println("l" + re);
    }
}
