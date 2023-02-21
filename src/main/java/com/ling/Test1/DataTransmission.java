package com.ling.Test1;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DataTransmission {

    public static void main(String[] args) {
        DataTest a = new DataTest(1);
        DataTest b = a;
        a = new DataTest(2);

        System.out.println(a.getA());
        System.out.println(b.getA());


        Calendar calendar = Calendar.getInstance();
        calendar.add(1, -1);
        System.out.println(calendar.getTime());

        String x = "11222";
        System.out.println(x.substring(2));

        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("YYYYMM");
        String format = simpleDateFormat.format(date);
        System.out.println(Integer.valueOf(format) -1 );


        String tbName = "event_history_202207";
        String prefix = "event_history_";
        String substring = tbName.substring(prefix.length());
        System.out.println(Integer.valueOf(substring));


        ;
        System.out.println(System.getProperty("user.dir"));
    }
}

class DataTest {
    private Integer a;

    public DataTest() {
    }

    public DataTest(Integer a) {
        this.a = a;
    }

    public Integer getA() {
        return a;
    }

    public void setA(Integer a) {
        this.a = a;
    }
}
