package com.bridge;

/**
 * 桥接模式
 */
public class BridgePattern {
    public static void main(String[] args) {
        Abstraction abstraction = new Abstraction();
        abstraction.setImplementation(new ImplementationImpl());

        abstraction.feature1();
        abstraction.feature2();
        abstraction.otherFeature();
    }
}

/**
 * 原有功能
 */
class Abstraction{
    Implementation implementation;

    public void setImplementation(Implementation implementation) {
        this.implementation = implementation;
    }

    void feature1(){
        implementation.method1();
    }
    void feature2(){
        implementation.method2();
    }
    void otherFeature(){
        System.out.println("otherFeature");
    }
}

/**
 * 分离出的功能
 */
interface Implementation{
    void method1();
    void method2();
}

class ImplementationImpl implements Implementation{

    @Override
    public void method1() {
        System.out.println("method1");
    }

    @Override
    public void method2() {
        System.out.println("method2");
    }
}