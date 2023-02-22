package com.ling.designMode.proxy.dynamicProxy.school;

/**
 * 学生
 */
public class Student implements SchoolRule{
    private String name;

    public Student(String name) {
        this.name = name;
    }

    public Student() {
    }

    //报名
    public void registration() {
        System.out.println("我叫" + name + ",来交报名费！");
    }
    // 获取教材
    public void getMaterial() {
        System.out.println("我叫" + name + ",交教材费！");
    }
    // 吃饭
    public void eat() {
        System.out.println("我叫" + name + ",交餐费！");
    }
}
