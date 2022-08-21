package com.adapter;

/**
 * 适配器模式
 */
public class AdapterPatterns {
    public static void main(String[] args) {
        Adaptee adaptee = new Adaptee();
        Target target = new Adapter(adaptee);
        target.method();
    }
}

/**
 * 适配器接口
 */
interface Target{
    String method();
}

/**
 * 适配器
 */
class Adapter implements  Target{
    Adaptee adaptee = null;
    Adapter(Adaptee adaptee){
        this.adaptee = adaptee;
    }

    @Override
    public String method() {
        String result = this.adaptee.spectificMethod();
        System.out.println(result);
        //对数据转换
        result = "适配器后的数据";
        System.out.println(result);
        return result;
    }
}

/**
 * 被适配的类
 */
class Adaptee{
    public String spectificMethod(){
        return "原始数据";
    }
}
