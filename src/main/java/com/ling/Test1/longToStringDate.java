package com.ling.Test1;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class longToStringDate {

    public static void main(String[] args) {
        System.out.println(timeToString("1651116961000"));;

        Integer ii = null;

        Map<String, Integer> imap = new HashMap<>();
        imap.put("1", (null == ii ? 1 : ++ii));

        System.out.println(imap);

        try{
            double v = Double.parseDouble("");
        } catch (Exception e) {

        }
        System.out.println();

    }

    public static String timeToString(String s){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date;
        try {
            date = sdf.parse(sdf.format(new Date(new Long(s))));
            //Date date = sdf.parse(sdf.format(new Long(s)));// 等价于
            return sdf.format(date);
        } catch (NumberFormatException e) {
            // TODO 自动生成的 catch 块
            e.printStackTrace();
        } catch (ParseException e) {
            // TODO 自动生成的 catch 块
            e.printStackTrace();
        }
        return null;
    }
}
