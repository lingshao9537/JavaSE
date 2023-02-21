package com.ling.Test1;

/**
 * @Author wanglz
 * @create 2021/7/5 17:58
 */
public class TestA {

    private Integer id;
    private Integer relation_id;

    public TestA() {
    }

    public TestA(Integer id, Integer relation_id) {
        this.id = id;
        this.relation_id = relation_id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRelation_id() {
        return relation_id;
    }

    public void setRelation_id(Integer relation_id) {
        this.relation_id = relation_id;
    }

    @Override
    public String toString() {
        return "TestA{" +
                "id=" + id +
                ", relation_id=" + relation_id +
                '}';
    }
}
