package com.ling.Test1;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author wanglz
 * @create 2021/8/16 16:40
 */
public class fileTest {
    public static void main(String[] args) {
        String filePath = "D:\\Temp\\file_01.zip";
        String filePath1 = "D:\\Temp\\file_02.zip";
//        createFile(filePath, filePath1);
        File file = new File(filePath);
        File file1 = new File(filePath1);
//        if (file.exists()) {
//            file.delete();
//        }
//        File newFile = new File(filePath);
//        if (file1.exists()) {
//            file1.renameTo(newFile);
//        }
        if (file.exists()) {
            file.renameTo(file1);
        }

        List<StringBuffer> strList = new ArrayList<>();
        StringBuffer stringBuffer1 = new StringBuffer("aaa");
        StringBuffer stringBuffer2 = new StringBuffer("bbb");
        StringBuffer stringBuffer3 = new StringBuffer("ccc");

        strList.add(stringBuffer1);
        strList.add(stringBuffer2);
        strList.set(0, stringBuffer3);
        stringBuffer3 = stringBuffer1;

        System.out.println(strList.get(0));

        List<User_01> user_01List = new ArrayList<>();
        User_01 user_01_01 = new User_01();
        user_01_01.setName("小二");
        user_01_01.setAge(2);
        User_01 user_01_02 = new User_01();
        user_01_02.setName("小三");
        user_01_02.setAge(3);
        User_01 user_01_03 = new User_01();
        user_01_03.setName("小四");
        user_01_03.setAge(4);

        user_01List.add(user_01_01);
        user_01List.add(user_01_02);
        user_01List.set(0, user_01_03);
        user_01_03 = user_01_01;
        user_01List.get(0).setName("小五");
        System.out.println(user_01_03);

    }



    public static void createFile(String filePath, String filePath1) {
        File file = new File(filePath);
        File file1 = new File(filePath1);
        try{
            file.createNewFile();
            file1.createNewFile();
        } catch (Exception e) {

        }
    }
}

class User_01 {
    private String name;
    private Integer age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User_01{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
