package com.ling.designMode.proxy.dynamicProxy.star;

/**
 * 若干个大明星出道了，准备开演唱会
 * 她们都会唱跳
 *
 * 但是她们没有认识的人，去帮她们租场地，租话筒，卖门票收钱  所以需要一个代理去做这些事情
 */
public class BigStar implements Star {

    private String name;

    public BigStar() {
    }

    public BigStar(String name) {
        this.name = name;
    }

    public String sing(String singName) {
        System.out.println(name + "正在演唱" + singName + "!");
        return "谢谢！谢谢！";
    }

    public void dance() {
        System.out.println(name + "正在跳舞!");
    }
}
