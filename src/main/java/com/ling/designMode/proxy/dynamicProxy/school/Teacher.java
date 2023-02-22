package com.ling.designMode.proxy.dynamicProxy.school;

public class Teacher implements SchoolRule{

    private String name;

    public Teacher() {
    }

    public Teacher(String name) {
        this.name = name;
    }

    @Override
    public void registration() {
        System.out.println("我叫" + name + ",来交报名费！");
    }

    @Override
    public void getMaterial() {
        System.out.println("我叫" + name + ",来交教材费！");
    }

    @Override
    public void eat() {
        System.out.println("我叫" + name + ",来交餐费！");
    }
}
