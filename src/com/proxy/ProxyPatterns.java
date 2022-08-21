package com.proxy;

/**
 * 代理模式
 */
public class ProxyPatterns {
    public static void main(String[] args) {
        Subject subject = new Proxy();
        subject.request();
    }
}

/**
 * 目标接口
 */
interface Subject{
    String request();
}

/**
 * 目标类
 */
class SubjectA implements Subject{
    @Override
    public String request() {
        System.out.println("访问了目标类数据");
        return "目标类数据";
    }
}

/**
 * 代理
 */
class Proxy implements Subject{
    /**
     * 代理类中的其他方法
     */
    public void conntent() {
        System.out.println("建立连接");
    }

    @Override
    public String request() {
        conntent();
        System.out.println("访问了代理类");
        String str = new SubjectA().request();
        System.out.println("获取到了目标数据");
        return str;
    }
}