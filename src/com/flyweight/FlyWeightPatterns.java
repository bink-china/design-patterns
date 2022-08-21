package com.flyweight;

import java.util.ArrayList;
import java.util.List;

/**
 * 享元模式
 */
public class FlyWeightPatterns {
    public static void main(String[] args) {
        FlyWeight weight1 = FlyWeightFactory.getInstance().getFlyWeight();
        weight1.useDbConn("aaa");
        FlyWeight weight2 = FlyWeightFactory.getInstance().getFlyWeight();
        weight2.useDbConn("bbb");
        weight2.backDbConn();
        FlyWeight weight3 = FlyWeightFactory.getInstance().getFlyWeight();
        weight3.useDbConn("ccc");
    }
}

/**
 * 享元抽象类
 */
abstract class FlyWeight{
    /**
     * 内部状态
     */
    protected Integer state = 0;

    /**
     * name 外部状态
     * 获取连接池
     * @param name
     */
    abstract void useDbConn(String name);

    /**
     * 释放连接池
     */
    abstract void backDbConn();

    public Integer getState() {
        return state;
    }
}

/**
 * 享元实现类
 */
class ConcreteFlyWeight extends FlyWeight{
    /**
     * 内部状态
     */
    protected Integer id;
    public ConcreteFlyWeight(Integer id) {
        this.id = id;
    }

    /**
     * name 外部状态
     * 获取连接池
     * @param name
     */
    @Override
    void useDbConn(String name) {
        System.out.println(name+"在使用连接池"+id);
        this.state = 1;
    }

    /**
     * 释放连接池
     */
    @Override
    void backDbConn() {
        this.state=0;
    }
}

/**
 * 享员工厂
 */
class FlyWeightFactory{
    /**
     * 静态实例
     */
    private static FlyWeightFactory factory = new FlyWeightFactory();
    /**
     * 连接池
     */
    List<FlyWeight> pool = new ArrayList<>();

    /**
     * 获取工厂实例
     * @return
     */
    public static FlyWeightFactory getInstance(){
        return factory;
    }


    private FlyWeightFactory(){
        for (int i = 0; i < 2; i++) {
            pool.add(new ConcreteFlyWeight(i));
        }
    }

    /**
     * 获取享元对象
     * @return
     */
    public FlyWeight getFlyWeight(){
        for (FlyWeight flyWeight : pool) {
            if(flyWeight.getState()==0){
                return flyWeight;
            }
        }
        return null;
    }
}