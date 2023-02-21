package com.ling.Test1;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Author wanglz
 * @create 2021/8/5 19:30
 */
public class RexTegTest {
    private static int count;

    public static void main(String[] args) {
        String str = "32143]";
        String pattern = "[`~!@#$%^&*()=|{}':;',\\[\\].<>/?~！@#￥%……&*（）【】‘；：“”’。，、？]";
        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(str);
        System.out.println(m.find());


        System.out.println("@@@@@@@@@@@@@@@@@@@@");

        long id = 999999999999999999L;
        long id2 = 999999999999999999L;
        String id1 = "999999999999999999";
        System.out.println(id1.equals(String.valueOf(id)));
        System.out.println(id==id2);


        String str1 = "StrStrStr";
        str1 = str1.replace("S", "s");
        System.out.println(str1);

        List<Integer> intList = new ArrayList<Integer>(){
            {add(1);add(2);add(3);add(4);add(5);add(6);}
        };
        
        intList.forEach(il -> {
            if (il < 3) {
                count++;
            }
        });

    }
}
