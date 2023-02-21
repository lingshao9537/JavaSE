package com.ling.reflection_mechanism;

public class Man {
    public static final String name = "王凌志";
    public static int height;
    public int age;

    public Man(){
        System.out.println("调用了Man的无参构造函数");
    }
    public Man(int aaa){
        System.out.println("调用了Man的有参构造函数,传递了参数"+aaa);
    }
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
        System.out.println("调用setAge方法，传入了"+age);
    }

    @Override
    public String toString() {
        return "Man{" +
                "age=" + age +
                '}';
    }
}
