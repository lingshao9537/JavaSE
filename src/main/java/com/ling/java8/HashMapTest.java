package com.ling.java8;


import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * jdk7 Hashmap 组成部分 数组 + 链表
 * jdk8 Hashmap 组成部分 数组 + 链表/红黑树
 * 链表转红黑树条件：
 *      当某个hash地址存放的entry对象(某个entry数组)的长度大于8
 *      当前hashmap中的总元素的个数大于64时
 */
public class
HashMapTest {
    public static void main(String[] args) {

        Map<String, List<String>> map = new HashMap<>();
        List<String> list = new ArrayList<>();
        list.add("11");
        list.add("12");
        list.add("13");
        list.add("14");
        map.put("1", list);

        for(String code:map.keySet()){
            List<String> list1 = map.get(code);
            list1.remove(2);
        }
        System.out.println(map.get("1"));

        List<String> list1 = new ArrayList<>();
        list1.add("9");
        System.out.println(list);
        list = list1;
        System.out.println(list);

        handleList(list, null);
        System.out.println("handleList:" + list);



        A a1 = new A(1,2);
        A a2 = new A(1,2);
        A a3 = new A(1,2);

        List<A> listA = new ArrayList<>();
        listA.add(a1);
        listA.add(a2);
        listA.add(a3);

        

        List list2 = new ArrayList();
        list2.add("null");
        for (Object ll : list2) {
            System.out.println(ll);
        }

    }

    public static String handleList(List<String> list, String result){
        list.clear();
        list.add("098");

        result = "1111";
        return result;
    }

    public <T> Set<T> castSetClass(Object ininValue, Class<T> clazz) {
    return null;
    }
}

class A {
    public int a ;
    public int b;

    A(int a, int b) {
        this.a = a;
        this.b = b;
    }
}

