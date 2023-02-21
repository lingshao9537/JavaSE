package com.ling.reflection_mechanism;

/**
 * 反射(Reflection)是被视为动态语言的关键，反射机制允许程序在执行期间借助Reflection API取得任何类的内部信息，并能直接操作任意对象的内部属性及方法
 *  加载完类以后，在堆内存的方法区中就产生了一个Class类型的对象(一个类只能有一个Class对象)，
 *  这个对象就包含了完整的类的结构信息。我们可以通过这个对象看到类的结构。
 *
 *  java反射机制提供的功能：
 *      1.在运行时判断任意一个对象所属的类。
 *      2.在运行时构造任意一个类的对象。
 *      3.在运行时判断任意一个类所具有的成员变量和方法。
 *      4.在运行时获取泛型信息
 *      5.在运行时调用任意一个对象的成员变量和方法。
 *      6.在运行时处理注解
 *      7.生成动态代理
 *
 *  反射相关的主要API
 *      1.java.lang.Class：代表一个类
 *      2.java.lang.reflect.Method：代表类的方法
 *      3.java.lang.reflect.Field：代表类的成员变量
 *      4.java.lang.reflect.Constructor：代表类的构造器
 *      ... ...
 *
 *      Class类
 *          1.Class本身就是一个类
 *          2.Class对象只能由系统建立对象
 *          3.一个加载的类在JVM中只会有一个Class实例
 *          4.一个Class对象对用的是一个加载到JVM中的一个.class文件
 *          5.每个类的实例都会记得自己是由哪个Class实例所组成
 *          6.通过Class可以完整的得到一个类中所有被加载的结构
 *          7.Class类是Reflection的根源，针对任何你想动态加载、运行的类，唯有先获得相应的Class对象。
 *
 *        获取Class类的实例
 *          1.已知具体类，通过类的class属性获取，最可靠，程序性能最高
 *          2.已知类实例，调用getClass()方法获取Class对象
 *          3.已知全类名，且该类在类路径下，通过调用Class类的静态方法forName()获取，可能会抛出ClassNotFoundException
 *          4.其他方式：
 *              ClassLoader cl = this.getClass().getClassLoader();
 *              Class class2 = cl.liadClass("全类名");
 *        可以有Class对象的：
 *          1.class:外部类、成员(成员内部类、静态内部类)、局部内部类、匿名内部类
 *          2.interface：接口
 *          3.[]：数组
 *          4.enum：枚举
 *          5.annotation:注解@interface
 *          6.primitive type：基本数据类型
 *          7.void
 *
 *     ClassLoader:类加载(类初始化)
 *       类的主动引用(一定会发生类的初始化)
 *          1.当虚拟机启动，先初始化main方法所在类
 *          2.new一个类的对象
 *          3.调用类的静态成员(除了final常量)和静态方法
 *          4.使用java.lang.reflect包的方法对类进行反射调用
 *          5.当初始化一个类，如果其父类没有被初始化，会先初始化它的父类
 *       类的被动引用(不会发生类的初始化)
 *          1.访问一个静态域，只有真正声明这个域的类才会被初始化(子类类名.父类静态属性 子类不会被初始化，父类初始化)
 *          2.通过数组定义类引用，不会触发此类的初始化 (Son[] s = new Son[2];  Son是正常的类，而数组定义类引用不会触发，但是该引用也不具备正常引用的功能)
 *          3.引用常量(final修饰的)不会触发此类初始化(常量在链接阶段就存入调用类的常量池了)
 *
 *      创建运行时类的对象
 *          1.有了Class对象，能做些什么
 *              创建类的对象：调用Class对象的newInstance()方法  (前提是默认调用了无参构造器)
 *                  要求：1) 类必须要有一个无参的构造器      2) 类的构造器的访问权限足够
 *              没有无参的构造器不能创建对象？      (显示调用指定形参类型构造器)
 *                  1) 通过Class类的getDeclaredConstructor(Class ... parameterTypes)取得本类的指定形参类型的构造器
 *                  2) 向构造器的形参中传递一个数组对象进去，里面包含了构造器中所需的各个参数。
 *                  3) 通过Constructor实例化对象。
 *
 *      通过反射获取运行时类的完整结构
 *          Field：全部的Filed
 *              public Field[] getFields()  返回此Class对象所表示的类或接口的public的Field
 *              public Field[] getDeclaredFields()  返回此Class对象所表示的类或接口全部的Field
 *              Field方法中：
 *                  以整数形式返回此Field的修饰符：public int getModifiers()
 *                  得到Filed的属性类型： public Class<?> getType()
 *                  返回Field的名称 public String getName()
 *          Method：全部的方法
 *              public Method[] getDeclaredMethods()  返回此Class对象所表示的类或接口的全部方法
 *              public Method[] getMethods()  返回此Class对象所表示的类或接口的全部public方法
 *              Method类中：
 *                  取得全部的返回值：public Class<?> getReturnType()
 *                  取得全部的参数：public Class<?>[] getParameterTypes()
 *                  取得修饰符：public int getModifiers()
 *                  取得异常信息：public Class<?>[] getExceptionTypes()
 *          Constructor：全部的构造器
 *              public修饰的构造器:public Constructor<T>[] getConstructors()
 *              全部的构造器 public Constructor<T>[] getDeclaredConstructors()
 *              Constructor类中：
 *                  取得修饰符：public int getModifiers();
 *                  取得方法名：public String getName();
 *                  取得参数类型：public Class<?>[] getParameterTypes();
 *          Superclass：所继承的父类   public Class<? Super T> getSuperclass() 返回表示此Class所表示的实体(类、接口、基本类型)的父类的Class
 *          Interface：实现的全部接口  public Class<?>[] getInterfaces()  确定此对象所表示的类或接口所实现的接口。
 *          Annotation：全部注解
 */


import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Reflection_explain {
    public static void main(String[] args) throws Exception {
        //1.获取Class对象 已知全类名
        Class man = Class.forName("com.ling.reflection_mechanism.Man");
        //  获取Class对象，已知具体类
        Class cl = Man.class;

        System.out.println(man == cl);/** 一个加载的类在JVM中只会有一个Class实例  所以就算不断反射，在堆中永远只分配一个Class空间  返回true*/
        System.out.println(cl.getName());

        /**
         * 1.判断这个对象引用是属于哪个类
         *  public final Class getClass(); //通过对象反射求出类的名称(全类名)
         */
        //  获取Class对象，已知类实例
        Man man3 = new Man();
        Class ct = man3.getClass();


        /**
         * 2.在运行时构造一个任意类的对象
         */
        Object ob = Class.forName("com.ling.reflection_mechanism.Man").newInstance();
        //根据全类名获取对应的Class对象
        Class ob1 =  Class.forName("com.ling.reflection_mechanism.Man");
        //调用指定参数结构的构造器，生成Constructor的实例
        Constructor constructor = ob1.getConstructor(int.class);  // getConstructor(形参类型.class)  对应的是类中只有一个int形参的构造函数
        //通过Constructor的实例创建对应类的对象，并初始化类属性
        Man man23 = (Man) constructor.newInstance(1);   //  newInstance(1) 对应的是给上面这个指定构造函数的形参赋值
        System.out.println("man23："+man23);
        /**
         *  调用指定方法：通过反射，调用类中的方法，通过Method类完成
         */
        //1.通过CLass类的getMethod("方法名",形参类型.class)方法取得Method对象
        Method method = ob1.getMethod("setAge",int.class);
        //2.使用Method的对象引用.invoke(初始化对象(newInstance后的对象),入参(对应int.class))
        //method.invoke(初始化对象(必填),入参(主要是对应int.class,类型是什么，这里的格式就是什么，可以为null，就是没有入参啦))
        method.invoke(man23,2);
        /**
         *  调用指定属性：在反射机制中，可以直接通过Field类操作类中的属性，Field提供的set方法和get方法就可以完成设置和取得属性内容的操作
         */
        Field field = ob1.getField("height");
        
        System.out.println();




        //2.获取字段
        System.out.println("************获取所有公有的字段********************");
        Field[] fieldArray = man.getFields();
        for(Field f : fieldArray){
            System.out.println(f);
        }

        System.out.println("************获取所有的字段(包括私有、受保护、默认的)********************");
        fieldArray = man.getDeclaredFields();
        for(Field f : fieldArray){
            System.out.println(f);
        }
        Field f1 = man.getField("name");
        System.out.println(f1);
        Field f2 = man.getField("age");
        Object man1 = Class.forName("com.ling.reflection_mechanism.Man").newInstance();
        f2.set(man1,1);
        //想要获取当前值，可以继续用方法的引用f2，调用get方法，传入man1对象，按照指定类型接收输出
        Integer a = (Integer) f2.get(man1);
        Object t = f2.get(man1);
        System.out.println(a);
        System.out.println(t);
        //想要获取当前对象以及值，直接强制类型转换，由Object类型 man1 向下转型为 Man。
        Man man2 = (Man) man1;
        System.out.println(man2.getAge());

        System.out.println(A.m);

    }


}

class A{
    static{

        m= 300;

    }

    static int m = 100;
}
