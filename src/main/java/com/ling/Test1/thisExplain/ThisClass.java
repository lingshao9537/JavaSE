package com.ling.Test1.thisExplain;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author wanglz
 * @create 2021/12/28 14:49
 */
public class ThisClass {
    private int a = 1;
    private int b = 1;

    private Map<String, ThisClass> cuMap = new HashMap<>();


    public void soutThis(){
        cuMap.put("11", this);

        System.out.println(cuMap.get("11").a);
    }

    public static void main(String[] args) {

    }
}
