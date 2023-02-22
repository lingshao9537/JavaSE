package com.ling.designMode.proxy.dynamicProxy.school;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class SchoolProxyHandler implements InvocationHandler {

    private SchoolRule student;

    public SchoolProxyHandler(SchoolRule student) {
        this.student = student;
    }

    public SchoolProxyHandler() {
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if (method.getName().equals("registration")) {
            System.out.println("先要去教导处报到！");
            method.invoke(student, args);
            System.out.println("报名成功");
        } else if (method.getName().equals("getMaterial")) {
            System.out.println("先要去教材办公室报到！");
            method.invoke(student, args);
            System.out.println("拿到教材了！");
        } else if (method.getName().equals("eat")) {
            System.out.println("先去管理处！");
            method.invoke(student, args);
            System.out.println("可以吃饭了！");
        }
        return null;
    }
}
