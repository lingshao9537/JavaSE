package com.ling.set_framework.collection_framework;

import java.util.*;

public class List_explain {
    public static void main(String[] args) {
        List list = new ArrayList(){
            {
                add(5);
                add(3);
                add(1);
            }
        };
        StringBuilder stringBuilder = new StringBuilder("1234567");
        stringBuilder.insert(0,"2");
        System.out.println(stringBuilder);


        list.add(6);
        Iterator_test(list.iterator(),list);
        list.add(0,4);
        Iterator_test(list.iterator(),list);
        list.remove(1);
        Iterator_test(list.iterator(),list);
        Object[] arr =  list.toArray();
        for (Object a:arr) {
            System.out.println(a);
        }

        String[] str = new String[5];
        for (String myStr:str) {
            System.out.print(myStr + " ");
        }
        System.out.println();
        for(int i = 0; i < str.length; i++){
            System.out.println(str[i]);
        }
    }

    /**
     *
     * @param iterator
     * @param list
     *  iterator迭代器  remove()方法，是可以在遍历的过程中删除被遍历集合的元素，但用的是iterator.remove()方法删除的，而不是集合的remove()方法。
     *          如果在遍历过程中删除被遍历集合元素，那么遍历过程会报错，
     */
    public static void Iterator_test(Iterator iterator,List list){
        while(iterator.hasNext()){
            Integer integer = (Integer) iterator.next();
            if(iterator.equals(1)){
                iterator.remove();
//                list.remove(/
            }else{
                System.out.print(integer+" ");
            }
        }
        System.out.println();
    }
}
