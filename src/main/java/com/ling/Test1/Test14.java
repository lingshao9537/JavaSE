package com.ling.Test1;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author wanglz
 * @create 2021/7/5 17:57
 */
public class Test14 {

    public static void main(String[] args) {

        List<TestA> testAList = new ArrayList(){{
            add(new TestA(1,10));
            add(new TestA(2,10));
            add(new TestA(3,20));
            add(new TestA(4,20));
            add(new TestA(6,30));
            add(new TestA(5,30));
            add(new TestA(7,40));
            add(new TestA(8,40));
            add(new TestA(9,50));
            add(new TestA(10,50));
            add(new TestA(12,60));
            add(new TestA(11,60));
        }};

        List<TestB> testBList = new ArrayList(){{
            add(new TestB(20,"A"));
            add(new TestB(40,"B"));
            add(new TestB(30,"C"));
            add(new TestB(10,"D"));
            add(new TestB(60,"E"));
            add(new TestB(50,"F"));
        }};

//        int sumA = 0;
//        for (int i = 0; i < testBList.size(); i++) {
//            for (int j = 0; j < testAList.size(); j++) {
//                if (testBList.get(i).getId() == testAList.get(j).getRelation_id()) {
//                    if (null == testBList.get(i).getaList()) {
//                        testBList.get(i).setaList(new ArrayList<>());
//                    }
//                    testBList.get(i).getaList().add(testAList.get(j));
//                }
//                sumA++;
//            }
//        }
//        System.out.println("一共运行了:" + sumA + "次");
//        testBList.forEach(testB -> {
//            System.out.println(testB);
//        });

        int sumA = 0;
        for (int i = 0; i < testBList.size(); i++) {
            List<TestA> delList = new ArrayList<>();
            for (int j = 0; j < testAList.size(); j++) {
                if (testBList.get(i).getId().equals(testAList.get(j).getRelation_id())) {
                    if (null == testBList.get(i).getaList()) {
                        testBList.get(i).setaList(new ArrayList<>());
                    }
                    testBList.get(i).getaList().add(testAList.get(j));
                    delList.add(testAList.get(j));
                }
                else if (delList.size() > 0) {
                    break;
                }
                sumA++;
            }
            if (null != delList && delList.size() > 0){
                testAList.removeAll(delList);
            }
        }
        System.out.println("一共运行了:" + sumA + "次");
        testBList.forEach(testB -> {
            System.out.println(testB);
        });
    }
}
