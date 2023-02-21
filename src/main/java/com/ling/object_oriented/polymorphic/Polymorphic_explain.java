package com.ling.object_oriented.polymorphic;

/**
 *  一、什么是多态 polymorphic：多态指一种行为，具有多个不同的表现形式
 *      前提：继承/实现 、 方法的重写 、 向上转型(父类引用指向子类对象)
 *
 *  二、多态的体现
 *      当使用多态调用方法时，首先检查父类中是否有该方法，如果没有，则编译错误，如果有，执行的是子类重写后的方法。
 *
 *  三、多态的静态绑定和动态绑定
 *      静态绑定：其实就是继承的扩展：final、static、static final 修饰的属性和方法无法被继承
 *      动态绑定：在运行时根据具体对象的类型进行绑定。就是指编译器在编译阶段不知道要调用哪个方法，运行期才能确定
 *      区别：重载方法(overloaded methods)使用的是静态绑定，而重写方法(overridden methods)使用的是动态绑定
 *
 *  四、虚方法(virtual)
 *      父类中被重写的方法都是虚方法（virtual）,只是相对存在，不用super基本上不会访问到。
 *
 *  五、向上转型
 *      父类引用指向一个子类对象时，便是向上转型  父类类型 变量名 = new 子类类型(); 如：Father f= new Son();
 *
 *  六、向下转型：想要调用子类特有的方法，必须做向下转型，向下转型之前，它得先向上转型。
 *      Father father = new Son();
 *      子类类型 变量名 = (子类类型) 父类变量名; 如:Son s =(Son) father;
 *      转换前，我们最好使用instanceof  变量名 instanceof 数据类型 用boolean类型接收。
 *      instanceof:判断某一个对象或者变量是否是某一个类的实例
 *      比如 Animal animal = new Dag();
 *        1.  Cat cat = (Cat) animal;  //编译错误
 *        2.   if(animal instanceof Dog){
 *             Dog dog = (Dog)animal;//向下转型
 *         }else if(animal instanceof Cat){ //不执行
 *             Cat cat = (Cat)animal;//向下转型
 *         }
 *
 *
 */


//父类：动物类
class Animal{
    public void eat(){
        System.out.println("eat");
    }
    public void call(){
        System.out.println("call");
    }
}
//猫类
class Cat extends Animal {
    //方法重写
    public void eat(){
        System.out.println("猫吃猫骨头");
    }
    public void call(){
        System.out.println("猫叫");
    }
}
//狗类
class Dog extends Animal {
    public void eat(){
        System.out.println("狗吃狗骨头");
    }
    public void call(){
        System.out.println("狗叫");
    }
}

//针对动物操作的工具类
class AnimalTool{
    private AnimalTool(){}//最好把工具类的构造方法私有，防止别人创建该类的对象。该类是工具类。

    //调用所以动物的功能
    public static void animalLife(Animal a){  //工具类，方法就写成static的，然后直接在测试类：工具类名.方法 使用。
        a.eat();
        a.call();
    }
}


public class Polymorphic_explain {
    public static void main(String[] args) {
        Animal c= new Cat();
        System.out.println(c instanceof Animal);
        System.out.println(c instanceof Cat);
        AnimalTool.animalLife(c);

        Dog d= new Dog();
        AnimalTool.animalLife(d);
    }
}


