package com.ling.designMode.proxy.dynamicProxy.star;

import com.ling.designMode.proxy.dynamicProxy.ProxyUtil;
import com.ling.designMode.proxy.dynamicProxy.star.BigStar;
import com.ling.designMode.proxy.dynamicProxy.star.Star;

public class StarProxyMain {

    public static void main(String[] args) {
        Star star = new BigStar("杨超越");
        Star starProxy = ProxyUtil.CreateProxy(star);
        String message = starProxy.sing("好运来");
        System.out.println(message);
        starProxy.dance();
    }
}
