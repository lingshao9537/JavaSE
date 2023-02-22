package com.ling.designMode.proxy.staticProxy;

/**
 * 静态代理
 *
 * 1.真实对象和代理对象都要实现同一个接口
 * 2.代理对象要代理真实的角色
 *
 * 优点：
 *  代理对象可以做真实对象做不了的事情
 *      代理对象可以做真实对象的事情，也可以做其他的事情
 *  真实对象可以更专注做自己的事情
 *      不需要关心其他做不到的事情，交由代理对象去处理
 *
 *
 * 其实Runnable和Callable接口实现开启线程就是一个简单的静态代理模式， 执行体方法才是真实要做的事情，多线程只是一种处理方式。
 * 方法可以自己执行，也可以交由多线程代理执行。   思考一下
 */


public class StaticProxyDemo {

    public static void main(String[] args) {
        Marry you = new You();
        Marry wendding = new WenddingCompany(you);
        wendding.HappyMarry();
    }
}


interface Marry {
    void HappyMarry();
}

class You implements Marry{

    @Override
    public void HappyMarry() {
        System.out.println("我要结婚了！ 好开心");
    }
}

class WenddingCompany implements Marry {
    // 代理谁？ 代理真实的对象
    private Marry you;

    public WenddingCompany() {
    }

    public WenddingCompany(Marry you) {
        this.you = you;
    }

    @Override
    public void HappyMarry() {
        after();
        you.HappyMarry(); // 代理真实对象调用
        before();
    }

    private void before() {
        System.out.println("婚礼结束了，收钱。。。");
    }

    private void after() {
        System.out.println("婚礼开始布置。。。");
    }


}

