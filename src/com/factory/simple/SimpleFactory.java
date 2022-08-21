package com.factory.simple;

import java.text.DateFormat;

/**
 * 简单工厂类
 */
public class SimpleFactory {

    public static void main(String[] args) {
        Product product = Factory.getProduct("A");
        product.method();
    }

    /**
     * 简单工厂类
     */
    static class Factory{
        public static Product getProduct(String type){
            if("A".equals(type)){
                return new ProductA();
            }else if("B".equals(type)){
                return new ProductB();
            }
            return null;
        }
    }

    /**
     * 抽象产品类
     */
    static abstract class Product{
        abstract void method();
    }

    /**
     * 产品类A
     */
    static class ProductA extends Product{
        @Override
        void method() {
            System.out.println("methodA");
        }
    }

    /**
     * 产品B
     */
    static class ProductB extends Product{
        @Override
        void method() {
            System.out.println("methodB");
        }
    }
}
