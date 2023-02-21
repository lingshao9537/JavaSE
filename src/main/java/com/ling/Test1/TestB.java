package com.ling.Test1;

import java.util.List;

/**
 * @Author wanglz
 * @create 2021/7/5 17:58
 */
public class TestB {
    private Integer id;
    private String grade;
    private List<TestA> aList;

    public TestB() {
    }

    public TestB(Integer id, String grade) {
        this.id = id;
        this.grade = grade;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public List<TestA> getaList() {
        return aList;
    }

    public void setaList(List<TestA> aList) {
        this.aList = aList;
    }

    @Override
    public String toString() {
        return "TestB{" +
                "id=" + id +
                ", grade='" + grade + '\'' +
                ", aList=" + aList +
                '}';
    }
}
