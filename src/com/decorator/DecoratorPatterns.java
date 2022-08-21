package com.decorator;

/**
 * 装饰器模式
 */
public class DecoratorPatterns {
    public static void main(String[] args) {
        Component component = new ConcreteComponent();
        ConcreteDecorator concreteDecorator = new ConcreteDecorator(component);
        concreteDecorator.selfMethod();
        concreteDecorator.method();
    }
}

/**
 * 抽象构件（原始对象）
 */
interface Component {
    void method();
}

/**
 * 具体构件
 */
class ConcreteComponent implements Component {
    @Override
    public void method() {
        System.out.println("原始对象方法");
    }
}

/**
 * 修饰器抽象接口（使用者可以不定义抽象类，直接使用）
 */
abstract class Decorator implements Component {
    /**
     * 持有原始对象
     */
    Component component = null;

    /**
     * 构造器注入原始对象
     * @param component
     */
    Decorator(Component component) {
        this.component = component;
    }

    /**
     * 原始方法
     */
    @Override
    public void method() {
        this.component.method();
    }
}

/**
 * 装饰器具体实现
 */
class ConcreteDecorator extends Decorator {
    /**
     * 构造器注入原始对象
     * @param component
     */
    ConcreteDecorator(Component component) {
        super(component);
    }

    /**
     * 修饰方法
     */
    public void selfMethod(){
        this.component.method();
        System.out.println("新增的方法");
    }
}