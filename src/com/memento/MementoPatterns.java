package com.memento;

import java.util.ArrayList;
import java.util.Stack;

/**
 * 备忘录模式
 */
public class MementoPatterns {
    public static void main(String[] args) {
        CareTaker careTaker = new CareTaker();

        Originator originator = new Originator();

        originator.ChangeState("aaa");

        careTaker.storeMemento(originator.createMemento());
        originator.ChangeState("bbb");

        careTaker.storeMemento(originator.createMemento());
        originator.ChangeState("ccc");

        originator.restoreMemento(careTaker.getMemento());
        System.out.println(originator.getState());

        originator.restoreMemento(careTaker.getMemento());
        System.out.println(originator.getState());
    }
}

/**
 * 原发器  需要被备忘的类
 */
class Originator{
    private String state;//备忘的数据
    /**
     * 创建备忘录
     */
    public Memento createMemento(){
        return new Memento(this.state);
    }

    /**
     * 恢复备忘录
     * @param memento
     */
    public void restoreMemento(Memento memento){
        this.state = memento.getState();
    }

    /**
     * 改变状态
     * @param state
     */
    public void ChangeState(String state){
        this.state = state;
    }

    public String getState() {
        return state;
    }
}

/**
 * 管理者类  存储历史
 */
class CareTaker{
    private Stack<Memento> stack = new Stack();

    /**
     * 保存备忘录
     * @param memento
     */
    public void storeMemento(Memento memento){
        stack.push(memento);
    }

    /**
     * 获取备忘录
     * @return
     */
    public Memento getMemento(){
        return stack.pop();
    }
}

/**
 * 备忘录类  默认包内可见
 */
class Memento{
    private String state;//保存的状态

    public Memento(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }
}