package com.ling.Test1;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class testList {
    public static void main(String[] args) {
//        test23 test23 = new test23();
//        test23.getChildren().add(new test23(3));

        List<Integer> linkList = new LinkedList<>();
        linkList.get(1);

        List<Integer> list11 = new ArrayList<Integer>(){
            {add(1); add(2); add(3); add(4);}
        };

        System.out.println(list11);
        list11.remove(2);
        System.out.println(list11);
    }
}
class test23 {
    private Integer id;

    private List<test23> children;

    public test23() {
    }

    public test23(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<test23> getChildren() {
        return children;
    }

    public void setChildren(List<test23> children) {
        this.children = children;
    }
}
