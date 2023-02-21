package com.ling.java8;

import com.ling.java8.Entryclass;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Stream的三个操作步骤：
 * 1.创建stream
 *
 * 2.中间操作
 *
 * 3.终止操作(终端操作)
 */
public class Streamnew {
    public static void main(String[] args) {
        //1.通过Collection系列提供的stream()方法
        List<Entryclass> list = new ArrayList<Entryclass>();
        Stream<Entryclass> stream1 = list.stream();
        //list转map   getClass_id 对应的是map中的key、getClass_name 对应的是map中的value
        Map map = stream1.collect(Collectors.toMap(Entryclass::getClass_id,Entryclass::getClass_name));
        System.out.println(map);
        Set<Entryclass> set = new HashSet<Entryclass>();
        Stream<Entryclass> stream7 = set.stream();
        //set转map   getClass_id 对应的是map中的key、getClass_name 对应的是map中的value
        Map map1 = stream7.collect(Collectors.toMap(Entryclass::getClass_id,Entryclass::getClass_name));
        //list转set   结构相同，所以直接用toSet()转
        Set<Entryclass> set1 = stream1.collect(Collectors.toSet());

        //2.通过Arrays中的静态方法stream()获取数组流
        Integer[] integers = new Integer[10];
        Stream<Integer> stream2 = Arrays.stream(integers);   //类似Array转list的方法。

        //3.Stream类中的静态方法of()
        Stream<String> stream3 = Stream.of("aa","bb","cc");

        //4.创建无限流
        //4.1 迭代
        Stream<Integer> stream4 = Stream.iterate(0,(x) -> x + 2);
    }
}
