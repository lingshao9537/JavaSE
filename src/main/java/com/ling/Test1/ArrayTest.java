package com.ling.Test1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author wanglz
 * @create 2021/12/30 17:46
 */
public class ArrayTest {
    public static void main(String[] args) {
        List<String> buList = new ArrayList<>();
        String[] bustr = {"1","2","3","4"};
        buList = Arrays.asList(new String("2"), new String("3"));
        List<String> bubList = new ArrayList<>();
        bubList.addAll(buList);

        System.out.println(bubList);

        String strPath = System.getProperty("user.dir");
        System.out.println("strPath: " + strPath);

    }
}
