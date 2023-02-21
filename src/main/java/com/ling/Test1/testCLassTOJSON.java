package com.ling.Test1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author wanglz
 * @create 2021/8/11 15:45
 */
public class testCLassTOJSON {
    private String[] users;
    private String[] deps;

    public String[] getUsers() {
        return users;
    }

    public void setUsers(String[] users) {
        this.users = users;
    }

    public String[] getDeps() {
        return deps;
    }

    public void setDeps(String[] deps) {
        this.deps = deps;
    }

    @Override
    public String toString() {
        return "testCLassTOJSON{" +
                "users=" + Arrays.toString(users) +
                ", deps=" + Arrays.toString(deps) +
                '}';
    }

    public static void main(String[] args) {
//        testCLassTOJSON t1 = new testCLassTOJSON();
//        String[] ar1 = {"111","222","333"};
//        String[] ar2 = {"111","222","333"};
//        t1.setDeps(ar1);
//        t1.setUsers(ar2);
//        System.out.println(t1);
//


        Map<String, Integer> map = new HashMap<>();
        map.put("a", 1);
        map.put("b", 2);
    }
}

class A {
    public int a;
    public int b;
}
