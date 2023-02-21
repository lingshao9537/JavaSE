package com.ling.stream;

import com.google.common.collect.Lists;

import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CollectionHandle {


    public void demo_01() {
        List<Relation> list = Lists.newArrayList();
        int i = 0;
        while (i < 5) {
            i++;
            list.add(new Relation(i, i + ""));
        }
        list.add(new Relation(2, "3"));
        list.add(new Relation(3, "4"));

        Stream<Relation> stream = list.stream();
        Collector<Relation, ?, Map<Integer, Relation>> relationMapCollector = Collectors.toMap(Relation::getPointId, y -> y, (oldvalue, newvalue) -> oldvalue);
        Map<Integer, Relation> collect = stream.collect(relationMapCollector);
        System.out.println(collect);
    }


    public static void main(String[] args) {
        new CollectionHandle().demo_01();
    }
}

class Relation {
    private Integer pointId;
    private String message;


    public Integer getPointId() {
        return pointId;
    }

    public void setPointId(Integer pointId) {
        this.pointId = pointId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Relation(Integer pointId, String message) {
        this.pointId = pointId;
        this.message = message;
    }

    @Override
    public String toString() {
        return "Relation{" +
                "pointId=" + pointId +
                ", message='" + message + '\'' +
                '}';
    }
}

