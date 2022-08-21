package com.factory.method;

import java.util.ArrayList;
import java.util.Collection;

/**
 * 工厂方法
 */
public class FactoryMethod {
    public static void main(String[] args) {
        Factory factory = new FactoryB();
        Product product = factory.getProduct();
        product.method();
    }

    /**
     * 工厂抽象类
     */
    static abstract class Factory{
        abstract Product getProduct();
    }

    /**
     * 工厂A
     */
    static class FactoryA extends Factory{
        @Override
        Product getProduct() {
            return new ProductA();
        }
    }

    /**
     * 工厂B
     */
    static class FactoryB extends Factory{
        @Override
        Product getProduct() {
            return new ProductB();
        }
    }


    /**
     * 产品抽象类
     */
    static abstract class Product{
        abstract void method();
    }

    /**
     * 产品A
     */
    static class ProductA extends Product{
        @Override
        public void method() {
            System.out.println("methodA");
        }
    }

    /**
     * 产品B
     */
    static class ProductB extends Product{
        @Override
        public void method() {
            System.out.println("methodB");
        }
    }

}
