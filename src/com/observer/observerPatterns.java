package com.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * 观察者模式
 */
public class observerPatterns {
    public static void main(String[] args) {
        Subject subject = new SubjectA();
        subject.register(new ObserverA());
        subject.register(new ObserverB());
        subject.notifyObserver();
    }
}

/**
 * 观察者接口
 */
interface Observer{
    void update();
}

/**
 * 观察者A
 */
class ObserverA implements Observer{
    @Override
    public void update() {
        System.out.println("A观察到了");
    }
}

/**
 * 观察者B
 */
class ObserverB implements Observer{
    @Override
    public void update() {
        System.out.println("B观察到了");
    }
}

/**
 * 被观察者接口
 */
interface Subject{
    /**
     * 注册
     * @param observer
     */
    void register(Observer observer);

    /**
     * 通知
     */
    void notifyObserver();
}

/**
 * 被观察者对象
 */
class SubjectA implements Subject{
    /**
     * 所有的注册对象
     */
    List<Observer> list = new ArrayList<>();

    /**
     * 注册
     * @param observer
     */
    @Override
    public void register(Observer observer) {
        list.add(observer);
    }

    /**
     * 通知所有观察者
     */
    @Override
    public void notifyObserver() {
        for (Observer observer : list) {
            observer.update();
        }
    }
}