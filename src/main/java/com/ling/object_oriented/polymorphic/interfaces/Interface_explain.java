package com.ling.object_oriented.polymorphic.interfaces;

public class Interface_explain {
    public static void main(String[] args) {
        Animal_01 animal_01 = new GoldFish();
        animal_01.sleep();
        Animal_02 animal_02 = (Animal_02) animal_01;
        animal_02.eat();
    }
}

interface Animal_01{
    void sleep();
}
interface Animal_02{
    public static final int head = 1;
    String name = "动物";
    public abstract void eat();
}

/**
 * 子接口可以选择性的继承父接口，但一般全继承
 *
 * 对于接口，里面的组成只有抽象方法和全局常量，所以很多时候为了书写简单，可以不用写public abstract 或者public static final。
 * 并且，接口中的访问权限只有一种：public，即：定义接口方法和全局常量的时候就算没有写上public，那么最终的访问权限也是public
 *
 * 从继承关系来说接口的限制比抽象类少：
 * （1）一个抽象类只能继承一个抽象父类，而接口可以继承多个接口；
 * （2）一个子类只能继承一个抽象类，却可以实现多个接口（在Java中，接口的主要功能是解决单继承局限问题）
 */
interface Fish extends Animal_01,Animal_02 {  //接口的多继承方式
    @Override
    void eat();

    @Override
    void sleep();

    void swim();
}

interface Gird extends Animal_01,Animal_02{
    @Override
    void eat();

    @Override
    void sleep();

    void fly();
}

class GoldFish implements Fish,Animal_02,Animal_01{ //接口的多实现方式
    public GoldFish(){
        System.out.println("我是金鱼");
    }
    @Override
    public void eat() {
        System.out.println("我能吃");
    }

    @Override
    public void sleep() {
        System.out.println("我能睡");
    }

    @Override
    public void swim() {
        System.out.println("我能游");
    }
}

class GoldFishSon extends GoldFish implements Fish{  //继承父类，同时实现接口

}

/**
 * static修饰的内接口或者内部抽象类
 */
interface machine{
    public void instructions();   //定义一个接口方法
    static interface type{       //定义一个内接口，用static修饰 表示一个外部接口
        public void lunch();
    }
    static abstract class size{   //定义一个内抽象类，用static修饰 表示外部抽象类
        public abstract void sizetype();
    }
}

class machinrMan implements machine.type{ //实现接口中的内接口，只能实现内接口的所有方法

    @Override
    public void lunch() {

    }
}

class machineWo implements machine{//实现接口，要实现接口的所有方法
    @Override
    public void instructions() {

    }
}

class machinehan extends machine.size{//实现接口中的内部抽象类，只能实现内部抽象类的所有抽象方法
    @Override
    public void sizetype() {

    }
}