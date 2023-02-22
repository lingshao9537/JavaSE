package com.ling.designMode.proxy.dynamicProxy;

import com.ling.designMode.proxy.dynamicProxy.school.SchoolProxyHandler;
import com.ling.designMode.proxy.dynamicProxy.school.SchoolRule;
import com.ling.designMode.proxy.dynamicProxy.star.Star;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyUtil {

    public static Star CreateProxy(Star bigStar) {
        /**
         * Object newProxyInstance(ClassLoader loader,Class<?>[] interfaces,InvocationHandler h)
         * 入参： 被代理类的类加载器，代理类接口，方法执行者
         */
        return (Star) Proxy.newProxyInstance(Star.class.getClassLoader(), bigStar.getClass().getInterfaces(), (proxy, method, args) -> {
            if (method.getName().equals("sing")) {
                System.out.println("先准备话筒，20W一个");
            } else if (method.getName().equals("dance")) {
                System.out.println("先准备场地，2000W一天");
            }
            return method.invoke(bigStar, args);
        });
    }

    public static SchoolRule CreateProxy(SchoolRule student) {
        InvocationHandler invocationHandler = new SchoolProxyHandler(student);
        return (SchoolRule) Proxy.newProxyInstance(SchoolRule.class.getClassLoader(), student.getClass().getInterfaces(), invocationHandler);
    }

}
