package com.ling.commonClass;

/**
 * 关于String StringBuffer StringBuilder常用类
 *  String
 */
public class String_stu {
    public static void main(String[] args) {
      String str = "HelloWorld.java";
      //获取字符串的长度  int length()
        System.out.println("字符串的长度为：" + str.length());
      //查找ch字符/st字符串在该字符串中第一次出现的位置 int indexOf(char ch / String st)  返回-1 即不存在该字符
        System.out.println("查找l字符在" + str + "中第一次出现的位置：" + str.indexOf('l'));
      //查找ch字符/st字符串在该字符串中最后一次出现的位置 int lastIndexOf(char ch / String st)  返回-1 即不存在该字符
        System.out.println("查找l字符在" + str + "中最后一次出现的位置：" + str.lastIndexOf('l'));
      //获取从beginIndex位置开始到结束的子字符串 String substring(int beginIndex , int endIndex) endIndex可为空，意味着一直到最后
        System.out.println("从指定位置开始到指定位置结束的子字符串：" + str.substring(1,4));
      //返回去除前后空格的字符串 String trim()
        System.out.println("返回去除前后空格的字符串：" + str.trim());
      //将该字符串与指定对象比较 boolean equals(Object obj)
        System.out.println("两个值是否相等：" + str.equals("Hello"));
      //与equals方法类似，忽略大小写
        System.out.println(" " + str.equalsIgnoreCase("hello"));
      //将字符串转换为小写 String toLowerCase()
        System.out.println("" + str.toLowerCase());
      //将字符串转换为大写 String toUpperCase()
        System.out.println("" + str.toUpperCase());
      //获取字符串中指定位置的字符 char charAt(int index)
        System.out.println("" + str.charAt(3));
      //将字符串分割为子字符串，返回字符串组 String[] split(String regex , int limit)  regex:从指定字符/字符串分割 limit：分割成几份
        String[] stArray = str.split("l",4);
        for (String stA:stArray) {
            System.out.print(stA + ",");
        }
        System.out.println();
      //将该字符串转换为byte数组 byte[] getBytes()
        byte[] btArray = str.getBytes();
        for (byte bt:btArray){
            System.out.print(bt + ",");
        }
      //将指定之字符串连接到此字符串的结尾。等价用"+"
        System.out.println(" " + str.concat(" World"));
      //比较两个字符串的大小 int compareTo  自然比较 字典比较 一个一个字符比较，不相等就是减去差值 看源码
        System.out.println(" " + "4560".compareTo("4568"));

      //测试此字符串是否以指定的后缀(从指定索引开始) 开始/结束 boolean startsWith/endsWith(String prefix/suffix (, int toffset))
        System.out.println(" " + str.endsWith(".java"));

      //替换此字符串中出现的所有oldChar  String replace(char oldChar , char newoldChar)



      String[] strArr = {"123", "456", "789"};
      System.out.println("String的join方法：" + String.join("-", strArr));


      System.out.println("****************************************************************");
      String fileName1 = "123/324/3214/rewio";
      String fileName = fileName1;
      String specailChar = "/";
      if (fileName.contains(specailChar)) {
        fileName = fileName.substring(fileName.lastIndexOf("/") + 1);
      }
      System.out.println("fileName: " + fileName);

      System.out.println("*******************************************");
      String ingoRange = "{user:\"123456\",\"123123\",\"ewqeqw\"}";
      System.out.println(ingoRange);
      String rangeD = "123";
      System.out.println(ingoRange.contains(rangeD));


      System.out.println("*******************************************");
      String cateA = "A0010027";
      String cateB = "A002034";
      String cateC = "B0030043";

      // String变成字符数组，取第一个元素的ASCII值进行比较
      System.out.println("cateA 和 cateB 比较：" + (cateA.getBytes()[0] == cateB.getBytes()[0]));
      // String取第一位元素比较
      System.out.println("cateA 和 cateB 比较：" + (cateA.substring(0, 1).equals(cateB.substring(0,1))));
      // 直接拿第一位
      System.out.println("cateA 和 cateB 比较：" + (cateA.charAt(0) == cateB.charAt(0)));
    }
}



