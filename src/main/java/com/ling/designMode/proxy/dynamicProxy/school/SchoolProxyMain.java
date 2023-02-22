package com.ling.designMode.proxy.dynamicProxy.school;

import com.ling.designMode.proxy.dynamicProxy.ProxyUtil;

import java.lang.reflect.Proxy;

/**
 * 校园代理实现
 */
public class SchoolProxyMain {
    public static void main(String[] args) {
        SchoolRule schoolProxy = null;

        SchoolRule student = new Student("wanglz");
        schoolProxy = ProxyUtil.CreateProxy(student);
        schoolProxy.registration();
        schoolProxy.getMaterial();
        schoolProxy.eat();


        SchoolRule teacher = new Teacher("xingyu");
        schoolProxy = ProxyUtil.CreateProxy(teacher);
        schoolProxy.registration();
        schoolProxy.getMaterial();
        schoolProxy.eat();

    }
}
