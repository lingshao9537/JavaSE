package com.ling.Test1;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author wanglz
 * @create 2021/6/30 15:48
 */
public class test13 {
    public static void main(String[] args) {
        String formula = "8+(A-1)*0.4";
        Integer A = 100;
        int indexA = formula.indexOf("A");
        System.out.println("A所在的位置：" + indexA);
        String formula1 = formula.replace("A", A+"");
        System.out.println("改变后的formula：" + formula1);


        class User{
            public String code;
            public String name;

            public String getCode() {
                return code;
            }

            public void setCode(String code) {
                this.code = code;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public User() {

            }

            public User(String code, String name) {
                this.code = code;
                this.name = name;
            }

            @Override
            public String toString() {
                return "User{" +
                        "code='" + code + '\'' +
                        ", name='" + name + '\'' +
                        '}';
            }
        }

        class UserInfo{
            private String code;
            private Integer grade;
        }
        List<User> list = new ArrayList(){{
            add(new User("D", "小四"));
            add(new User("B", "小二"));
            add(new User("A", "小一"));
            add(new User("C", "小三"));
            add(new User("D", "小八"));
            add(new User("B", "小六"));
            add(new User("A", "小五"));
            add(new User("C", "小七"));
        }};
        List<User> newList = list.stream().sorted(Comparator.comparing(User::getCode)).collect(Collectors.toList());


        List<User> sumList = new ArrayList<>();


        newList.forEach(user -> {
            if ("A".equals(user.getCode())){
                sumList.add(user);
            }
        });

        newList.removeAll(sumList);

        System.out.println("处理后的newList的长度：" + newList.size());


        StringBuffer sb = new StringBuffer();
        try{
            if (sb.lastIndexOf(",") == sb.length() - 1) {
                System.out.println(sb);
            }else {
                System.out.println("tu;e");
            }
        } catch (Exception e) {
            System.out.println("错了");
        }
    }
}
