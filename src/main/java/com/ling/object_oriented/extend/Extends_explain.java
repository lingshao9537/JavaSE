package com.ling.object_oriented.extend;

/**
 *  继承 Encapsulation ：多个类存在相同属性和方法时，将这些内容抽取到单独的一个类中，那么多个类就无需再定义这些属性和方法。
 *  （成千上万个函数，定义成千上万个方法名，如果有继承关系，会要缩减工作量。）继承描述的是事物之间的所属关系(is - a)
 *    1.定义：就是子类继承父类的属性和方法，使得子类对象具有与父类相同的属性、相同的方法。子类可以直接访问父类中的非私有属性和方法。间接访问私有属性(set、get)。
 *         在子类继承父类的同名方法中：1.调用父类的方法：super.方法() 2.重写父类方法
 *         在子类与父类有同名属性情况下：调用父类属性：super.属性  调用子类属性：this.属性  调用局部变量：属性
 *
 *          <clinit>方法(类初始化方法)：由静态类变量显示赋值代码和静态代码块组成
 *          <init>方法(对象初始化方法)：非静态实例变量显示赋值代码和非静态代码块、对应构造器代码组成
 *              （如果没有检测到或收集到构造函数的存在，那么就不会执行对象的初始化方法（<init>方法），一般是在实例化对象的时候执行)
 *                但是在继承中，是在子类实例化对象的时候执行。
 *          类的实例化顺序  比如 类 A  A a = new A();
 *          1.A  声明 A ，执行隐式的<clinit>方法，先给A的静态变量赋初值。
 *          2.A(); 调用父类A的构造方法，执行隐式的<init>方法，给A的非静态成员变量赋初始值，继续执行构造方法代码。
 *          3.new A(); 创建本类A的实例。
 *          4.A a = new A(); 将创建的对象实例赋值给a对象
 *
 *          子类实例化的顺序  比如 父类A  子类B  B b = new B();
 *          1.B   声明子类B之前，会先声明 A ，执行隐式的<clinit>方法，先给父类A的静态变量赋初值，
 *                然后再声明B ，执行隐式的<clinit>方法，给本类B的静态变量赋初始值。
 *          2.B(); 调用子类的构造器，但是构造器中的第一行会有一个隐式的super();
 *                  会先调用父类A的构造方法，执行隐式的<init>方法，给A的非静态成员变量赋初始值，继续执行构造方法代码。
 *                  然后调用本类B的构造函数，执行隐式的<init>方法，再给本类B的非静态成员变量赋初始值，最后执行构造方法代码。
 *          3.new B(); 创建本类B的实例。
 *          4.B b = new B(); 将创建的对象实例赋值给b对象
 *
 *            super和this：super代表的是对父类对象的引用，this代表的是对当前对象的引用。
 *                因为实例化当前类，创建当前类对象。也会(执行<clinit>方法)调用父类的构造方法(执行<init>)。前者代表是this，后者代表是super。
 *                当类未被实例化的时候，通过类名调用静态属性(类属性)[类名.static变量]，当类被实例化时，通过this调用成员属性(包括实例变量和静态变量)
 *                所以相对于父类来说，super是同样的用法。
 *               此外This和super都不能在main()方法中使用因为，main()方法是静态的，this是本类对象的引用，静态先于对象，所以是不能使用的。
 *              只要是类，都存在构造器。
 *
 *            提一点：类中无法被继承的方法：两个方面
 *              权限方面：用private修饰的方法、属性无法被继承(方法对于子类不可见，属性不可间接访问)
 *              类加载方面：final、static、static final 修饰的属性和方法无法被继承
 *
 */

class Father{
    public static String name = "李刚";
    public static String sex = "男";
    public int age = 45;
    public int height = 180;
    private int money = 1000000;
    public static String introduce = "子类调我";

    public Father(){
        System.out.println("调用父类的无参构造方法");
    }
    public Father(Father father){
        System.out.println("调用父类的有参构造方法");
    }
    public void setMoney(int money) {
        this.money = money;
    }

    public int getMoney() {
        return money;
    }

    public void introduce(){
        System.out.println("爸爸的自我介绍");
    }
    public void run(){
        System.out.println("爸爸会跑步");
    }
    public void car(){
        System.out.println("爸爸会开车");
    }
}

class Son extends Father{
    static{
        System.out.println("子类初始化了");
    }
    public static String name = "李小刚";
    public static String sex = "男";
    public int age = 21;
    public int height = 182;
    private int money = 100000;


    public  Son(){
        System.out.println("调用子类的无参构造方法");
    }
    public Son(Son son){
        System.out.println("调用子类的有参构造方法");
    }

    /**
     * 区分子类方法中重名的三种变量
     *
     */
    @Override
    public void introduce() {
        String name = "马蓉";
        System.out.println("大家好，我是父亲："+super.name);
        System.out.println("大家好，我是儿子："+this.name);
        System.out.println("大家好，我是儿媳妇："+name);

    }

    @Override
    public void run() {
        super.run();
    }

    @Override
    public void car() {
        super.car();
    }
}



public class Extends_explain {
    public static void main(String[] args) {
//        Son son = new Son();
//        son.introduce();
        System.out.println(Son.introduce);
        Son[] s = new Son[2];
        System.out.println(s.getClass());


    }
}
