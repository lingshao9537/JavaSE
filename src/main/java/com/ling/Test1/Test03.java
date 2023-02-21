package com.ling.Test1;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Test03 {
    public static void main(String[] args) {
        List<A1> a1s = new ArrayList<A1>(){
            {
                add(new A1(10000L, "张三", -1L));
                add(new A1(20000L, "李四", -1L));
                add(new A1(30000L, "王五", -1L));
                add(new A1(40000L, "赵六", 10000L));
                add(new A1(50000L, "老七", 10000L));
                add(new A1(60000L, "大一", 20000L));
                add(new A1(70000L, "大二", 20000L));
                add(new A1(80000L, "大三", 30000L));
                add(new A1(90000L, "大四", 30000L));
            }
        };

        List<A1> newA1s = new ArrayList<>();
        for (A1 a : a1s) {
            if (a.getP_id().compareTo(-1L) == 0) {
                newA1s.add(a);
            }
        }
        a1s.removeAll(newA1s);
        for (A1 a : newA1s) {
            List<A1> ss3 = new ArrayList<>();
            for (A1 b : a1s) {
                if (a.getId().compareTo(b.getP_id()) == 0) {
                    ss3.add(b);
                }
            }
            if (ss3.size() > 0) {
                a.setChildren(ss3);
            }
        }

        for (A1 a:newA1s
             ) {
            System.out.println(a);
        }

        Long l1 = new Long(11L);
        Long l2 = 12L;
        Integer i1 = new Integer(11);
        Integer i2 = 138;
        Long l3 = 1234567890L;
        Long l4 = 1234567890L;
        boolean l1l2 = i1 == i2;
        boolean l3l4 = l3 == l4;
        boolean l3l42 = l3.equals(l4);
        boolean l3l41 = l3.compareTo(l4) == 0;
        System.out.println("l1比较l2"+ l1l2);
        System.out.println("l3比较l4"+ l3l42);

        System.out.println("......................");

        A1 a12 = new A1(1L, "11", 10L);
        A1 a13 = new A1(1L, "11", 10L);
        System.out.println("a12: " + a12.hashCode());
        System.out.println("a13: " + a13.hashCode());
        System.out.println("a12 与 a13比较：" + (a12 == a13));
        a13 = a12;
        System.out.println("a12 与 a13比较：" + (a12 == a13));
        a12.setId(33L);
        System.out.println("a12: " + a12.hashCode());
        System.out.println("a13: " + a13.hashCode());
    }
}

class A1 implements Serializable {
    private Long id;
    private String name;
    private Long p_id;
    private List<A1> children;

    public A1(Long id, String name, Long p_id) {
        this.id = id;
        this.name = name;
        this.p_id = p_id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getP_id() {
        return p_id;
    }

    public void setP_id(Long p_id) {
        this.p_id = p_id;
    }

    public List<A1> getChildren() {
        return children;
    }

    public void setChildren(List<A1> children) {
        this.children = children;
    }

    @Override
    public String toString() {
        return "A1{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", p_id=" + p_id +
                ", children=" + children +
                '}';
    }
}
