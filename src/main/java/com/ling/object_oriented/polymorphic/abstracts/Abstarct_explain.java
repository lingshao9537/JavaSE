package com.ling.object_oriented.polymorphic.abstracts;

/**
 *  一、abstract class:抽象类
 *      在类的继承中，如果一个个新的子类被定义，子类变得越来越具体，父类变得更加一般和通用，
 *  类的设计应该保证父子类能够共享特征，有时将父类设计得非常抽象，使得父类没有具体的实例，这样的类叫做抽象类；
 *  一般当我们设计一个类，不需要创建此类的实例时，可以考虑将该类设置成抽象类，让其子类实现这个类的抽象方法
 *
 *  抽象类的特征：
 *  (1)不可被实例化
 *  (2)抽象类是有构造器的（所有类都有构造器），子类继承抽象类的时候，实例化会调用init()方法，其中就包含了所继承抽象类的构造器。参考继承。
 *  (3)抽象方法所在的类，一定是抽象类（因为抽象方法是没有方法体的，如果所在的类不是抽象类，那么该类可以实例化对象，调用抽象方法，然后无方法体去具体实现功能，则矛盾）
 *  (4)抽象类可以没有抽象方法的（抽象类可以有无抽象方法，也可以有无普通方法）
 *  (5)子类继承抽象类与子类继承普通类的区别，抽象类不可被实例化、子类必须继承和实现抽象类中所有的抽象方法
 *
 *  二、abstract method:抽象方法
 *      abstract修饰的方法为抽象方法
 *
 *  抽象方法的特征：
 *  (1)格式，没有方法体，包括{ }，例如  public abstract void dink();
 *  (2)抽象方法只保留方法的功能，具体的执行，交给继承抽象类的子类，由子类重写改抽象方法
 *  (3)如果子类继承抽象类，并重写了父类的所有的抽象方法，则此子类不是抽象类，可以实例化的
 *  (4)如果子类继承抽象类，没有重写父类中所有的抽象方法，意味着子类中还有抽象方法，那么此子类必须必须声明为抽象的。
 *
 *  三、抽象类的使用场景，一般运用在多态中。
 */

/**
 * 代码流程：
 *      定义一个抽象类Animal_01 拥有抽象方法 eat()，sleep()
 *      定义抽象类 Dog、Cat 继承 Animal_01
 *          Dog 继承Animal_01的全部抽象方法，新定义抽象方法：看家 House_keep()
 *          Cat 继承Animal_01的全部抽象方法，新定义抽象方法：抓老鼠 Catch_mice()
 *      定义子类 ColorfulCat、BlackDog 分别继承 Cat、Dog
 *          继承所有的抽象方法并重写。
 */
abstract class Animal_01{
    abstract public void eat();
    abstract public void sleep();

    public Animal_01(){} //抽象类是可以有构造方法的
}

/**
 * 抽象类在继承抽象类的时候，在对于抽象方法的继承上，允许部分继承
 */
abstract class Cat extends Animal_01{
    @Override
    abstract public void eat();
    @Override
    abstract public void sleep();
    abstract public void catchMice();
}

abstract class Dog extends Animal_01{
    static int a;
    int ab = 2;
    Dog(){
        System.out.println(Dog.a);
    }
    abstract public void eat();
    abstract public void sleep();
    abstract public void House_keep();
}

/**
 *  普通类在继承抽象类的时候，必须实现所有的抽象方法
 */
class ColorfulCat extends Cat{

    @Override
    public void eat() {

    }

    @Override
    public void sleep() {

    }

    @Override
    public void catchMice() {

    }

    public void Catch_mice() {

    }
}

class BlackDog extends Dog{
    static int a ;

    @Override
    public void eat() {
        System.out.println(this.a);
        System.out.println(super.a);
        System.out.println(super.ab);
    }

    @Override
    public void sleep() {

    }

    @Override
    public void House_keep() {

    }
}

/**
 * static去修饰abstract类
 */
abstract class cup{
    static abstract class newcup{  //定义一个内抽象类，用static修饰 表示外部抽象类
        abstract void size();
    }
    abstract void type();
}

class flowercup extends cup{ //子类在继承抽象类的时候，需要实例化全部的抽象方法

    @Override
    void type() {

    }
}
class sizecup extends cup.newcup{ //子类在继承抽象类的内部抽象类的时候，只能实现所继承的内部抽象类的所有抽象方法
    @Override
    void size() {

    }
}


public class Abstarct_explain {
    public static void main(String[] args) {
        BlackDog blackDog = new BlackDog();
        blackDog.eat();
    }
}
