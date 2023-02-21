package com.ling.set_framework.collection_framework;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 * Iterator和ListIterator区别
 * 我们在使用List,Set的时候，为了实现对其数据的遍历，我们经常使用到了Iterator(迭代器)。使用迭代器，你不需要干涉其遍历的过程，只需要每次取出一个你想要的数据进行处理就可以了。
 *
 * 但是在使用的时候也是有不同的。List和Set都有iterator()来取得其迭代器。对List来说，你也可以通过listIterator()取得其迭代器，两种迭代器在有些时候是不能通用的，Iterator和ListIterator主要区别在以下方面：
 *
 * 1. ListIterator有add()方法，可以向List中添加对象，而Iterator不能
 *
 * 2. ListIterator和Iterator都有hasNext()和next()方法，可以实现顺序向后遍历，但是ListIterator有hasPrevious()和previous()方法，可以实现逆向（顺序向前）遍历。Iterator就不可以。
 *
 * 3. ListIterator可以定位当前的索引位置，nextIndex()和previousIndex()可以实现。Iterator没有此功能。
 *
 * 4. 都可实现删除对象，但是ListIterator可以实现对象的修改，set()方法可以实现。Iierator仅能遍历，不能修改。
 *
 * 因为ListIterator的这些功能，可以实现对LinkedList等List数据结构的操作。其实，数组对象也可以用迭代器来实现。
 */
public class Iterater_explain {
    static int num = 6;
    public static void main(String[] args) {
        List list = new ArrayList();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        Iterator iterator = list.iterator();
        ListIterator listIterator = list.listIterator();
        System.out.println("*******Iterater遍历*******");

        Iteraterp(iterator);
        System.out.println();
        System.out.println("*******ListIterater增加元素遍历*******");
        ListIteraterpadd(listIterator);
        System.out.println();
        System.out.println("*******ListIterater反向遍历*******");
        ListIteraterp(listIterator);
        boolean result = trytest();
        System.out.println(result);

    }

    private static boolean trytest() {
        try {
            int b = 3 / 0;
            return true;
        }catch (Exception e){
            System.out.println("catch");
            return false;
        }finally {
            System.out.println("finally");
        }
    }

    private static void ListIteraterp(ListIterator listIterator) {
        while (listIterator.hasPrevious()){
            System.out.println(listIterator.previousIndex()+":"+listIterator.previous());
        }
    }

    public static void Iteraterp(Iterator iterator){
        while (iterator.hasNext()){
            System.out.print(iterator.next()+" ");
        }
    }
    public static void ListIteraterpadd(ListIterator listIterator){

        while (listIterator.hasNext()){

            System.out.println(listIterator.nextIndex() + ":" + listIterator.next());
            listIterator.add(num++);
        }
    }


}
