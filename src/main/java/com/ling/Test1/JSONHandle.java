package com.ling.Test1;

public class JSONHandle {
    public static void main(String[] args) {
        String str = "/32/12/12/12/12/dsadas";
        String str1 = str.substring(0, str.lastIndexOf("/") + 1);
        System.out.println(str1);
    }
}
