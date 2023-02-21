package com.ling.enumstu;

public enum enum_day01 {

    ONE(1, "一"),TWO(2, "二"),THREE(3, "三");

    private Integer key;
    private String value;

    enum_day01(int i, String s) {
        this.key = i;
        this.value = s;
    }

    public String getValueByKey(Integer key) {
        for (enum_day01 em : enum_day01.values()) {
            if (em.key == key) {
                return em.value;
            }
        }
        return "";
    }


}
