package com.ling.Test1;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Author wanglz
 * @create 2021/8/24 14:58
 */
public class regexCC {
    public static void main(String[] args) {
        String child = "\\.";
        String str = "123212.321";
        Pattern p = Pattern.compile(child);
        Matcher m = p.matcher(str);
        int count = 0;
        while (m.find()) {
            count++;
        }
        System.out.println(count);

        String[] str1 = null;
        str1 = str.split("\\.");
        System.out.println(str.split("\\.").length);
    }
}
