package com.ling.Test1;


import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * @Author wanglz
 * @create 2021/8/16 14:34
 */
public class urlTestEmpty {
    public static void main(String[] args) {
        System.out.println(checkStringContainsUrl("我是http://www.baidu.com"));
        System.out.println(checkStringContainsUrl("我是http://www.baidu"));
        System.out.println(checkStringContainsUrl("我是.http://www.baidu.com1111大萨达撒，分为"));
        System.out.println(checkStringContainsUrl("我是www.baidu.com"));
        System.out.println(checkStringContainsUrl("我是baidu.c:1"));
        System.out.println(checkStringContainsUrl("你不来我的世界找我，那我就去你的世界找你。.http://ab.aaweraw.com/a/c/53/53123.apk"));
        System.out.println(checkStringContainsUrl("我要去访问192.168.1.156"));
    }

    public static boolean checkStringContainsUrl(String str) {
        str = str.toLowerCase();
        String regex = "^*((https|http|ftp|rtsp|mms)?://)"
                + "?(([0-9a-z_!~*'().&=+$%-]+: )?[0-9a-z_!~*'().&=+$%-]+@)?" //ftp的user@
                + "(([0-9]{1,3}\\.){3}[0-9]{1,3}" // IP形式的URL- 199.194.52.184
                + "|" // 允许IP和DOMAIN（域名）
                + "([0-9a-z_!~*'()-]+\\.)*" // 域名- www.
                + "([0-9a-z][0-9a-z-]{0,61})?[0-9a-z]\\." // 二级域名
                + "[a-z]{2,6})" // first level domain- .com or .museum
                + "(:[0-9]{1,4})?" // 端口- :80
                + "((/?)|" // a slash isn't required if there is no file name
                + "(/[0-9a-z_!~*'().;?:@&=+$,%#-]+)+/?)*$";

        Pattern p = Pattern.compile(regex);
        Matcher matcher = p.matcher(str);
        return matcher.find();
    }
}
