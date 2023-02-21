package com.ling.commonClass;

public class StringBuilder_stu {
    public static void main(String[] args) {
        StringBuilder stuBuild1 = new StringBuilder("Hello");
        StringBuilder stuBuild2 = new StringBuilder("Hello World");

        String str = new String("123");
        System.out.println(str.hashCode());
        str = str + "123";
        System.out.println(str.hashCode());



        System.out.println();

        StringBuilder stringBuilder = new StringBuilder(10);
        StringBuilder str1 = new StringBuilder(10);
        stringBuilder.append("SUM(");
        str1 = stringBuilder;
        if (stringBuilder.lastIndexOf("(") == stringBuilder.length() - 1) {
            System.out.println("11111111111");
        }
        stringBuilder.append("232");
        str1.append("11");

        System.out.println("str1:" + str1);
        System.out.println("stringbuilder:" + stringBuilder);
        System.out.println(1+(2)+"");

        str1.insert(0, "A");
        System.out.println("首位置插入：" + str1);
    }
}
