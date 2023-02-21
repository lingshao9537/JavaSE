package com.ling.object_oriented;

/**
 *  面向对象  Hello hello = new Hello();  or  Hello hello; hello = new Hello();  类 变量(引用) = 对象：
 *      1.对象：万事万物皆对象，类的实例。 new Hello();
 *      2.对象引用： hello  （类定义了一个变量。这个变量是一个引用，指向的是一个对象）
 *      3.对象实例：其实没有对象实例这一说，只有类的实例(对象) 直接理解为对象引用：hello
 *      4.引用变量： 引用类型声明的变量， Hello：引用类型  hello：引用变量
 *      5.对象和对象引用：
 *          1.在同一个引用类型下：一个对象引用可以指向零个或一个对象。
 *              一个对象引用对应一个对象(堆中的内存地址)。
 *              对象引用不变的前提下，对象是可以重新new出来的，旧对象被回收，新对象被引用所指。(随着新对象的指向，对象引用的地址值变了)
 *          2.在同一个引用类型下：一个对象可以被一个或多个对象引用。
 *              一个对象(堆中的内存地址)可以对应多个对象引用。
 *              对象不变的前提下，可以不断声明出新的对象引用，由对象引用指向对象引用间接指向对象。
 *              引用1指向引用2，引用1所指向的对象会将地址值赋值给引用2。而不是引用1将地址值赋值。
 *              (指向就是赋地址值，对象将地址值赋给了最初指向的对象引用，最初给接下来的对象引用赋值，到后面栈中的对象引用的地址值都是一样的)
 *
 *    一切皆对象，变量只是一个零时的存储地址，引用类型的变量只是一个普通的变量，存储的引用类型的地址。对象的创建是在堆中分配了一个内存。
 *    基本数据类型：桶1是空桶  桶2是鱼桶，从桶2中丢一条鱼给桶1，桶1变成了鱼桶，但是桶1不是桶2
 *    引用数据类型：甲拿着好桶，已拿着坏桶，甲愿意与已分享好桶，已扔掉坏桶，坏桶被收破烂的给收走了，甲和已同时用好桶。而不是甲愿意把自己给已分享。
 */
public class Object_oriented_explain {
    public static void main(String[] args) {
        Hello hello = new Hello();  //hello是对象引用，实际的对象在内存里(堆中)
        hello = new Hello();    //现在hello是对另一个对象的引用，之前的对象被当垃圾回收了(因为之前的对象不能再使用了)
        Hello hello1;       //定义了一个新的引用hello1 他没有指向任何对象，不能使用
        hello1 = new Hello();       //hello1成了对象的引用
        Hello hello2 = new Hello();     //定义新的引用，创建新的对象
        Hello hello3 = new Hello();     //定义新的引用，创建新的对象
        hello2 = hello3;            //hello2 引用 hello3的对象
        int a = 4;
        int b = 5;
        a = b;      //赋值，a b 还是引用不同的对象。

        final Hello hello4 = new Hello();
            hello4.a=2 ;

            String r = "Hello1";
            String s = "Hello";
            String w = "Hello";
        System.out.println(s == w);
            s = s + 1;
            w = w + 1;
        System.out.println(s == r);
        System.out.println(s == w);
        System.out.println(w == r);


        String a1 = "Hello1";

        final String b1 = "Hello";
        String f = "Hello";

        String c = b1 + 1;
        String e = f + 1;

        System.out.println(a1 == c);
        System.out.println(a1 == e);

    }
}

class Hello{
    public int a = 1;
    public int b = 2;
    /**
     * final定义的成员变量在类对象实例化之前必须赋初值，也就是说在堆中为对象开辟内存之前，一定要初始化。
     */
    public final int c = 1;


}
