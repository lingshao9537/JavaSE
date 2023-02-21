package com.ling.Test1;

public class October_01 {
    public static void main(String[] args) {
        String  mongoAuth = "root:Abc@2020";
        String mU = mongoAuth.substring(0 , mongoAuth.indexOf(":"));
        String mP = mongoAuth.substring(mongoAuth.indexOf(":") + 1, mongoAuth.length());

        String[] arr = mongoAuth.split(":");
        System.out.println(arr.length);
        String[] arr1 = new String[arr.length];
        for (int i = 0 ; i < arr.length ; i++){
            arr1[i] = arr[i];
        }
        for (String a:arr1
             ) {
            System.out.println(a);
        }

        System.out.println("mu:" + mU);
        System.out.println("mp:" + mP);

        String str = "1111";
        String[] strArr = str.split(",");
        Long[] longs = new Long[strArr.length];
        for( int i = 0; i < strArr.length; i++){
            longs[i] = Long.valueOf(strArr[i]);
        }
        for (Long l:longs
             ) {
            System.out.println(l);
        }

        String str2 = "111.zip";
        int i = str2.indexOf(".");
        if(".zip".equals(str2.substring(i))) {
            System.out.println("是压缩包");
        }
        ;
    }
}
