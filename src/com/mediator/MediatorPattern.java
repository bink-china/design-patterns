package com.mediator;

/**
 * 中介者模式
 */
public class MediatorPattern {
    public static void main(String[] args) {
        MediatorImpl mediator = new MediatorImpl();
        ComponentA componentA = new ComponentA("A",mediator);
        ComponentB componentB = new ComponentB("B",mediator);
        mediator.setComponentA(componentA);
        mediator.setComponentB(componentB);
        componentB.sendMsg("能收到消息吗");
        componentA.sendMsg("可以");
    }
}

/**
 * 中介者接口
 */
interface Mediator{
    void notify(String msg,Component component);
}

/**
 * 中介者实现类
 */
class MediatorImpl implements Mediator{
    ComponentA componentA;
    ComponentB componentB;

    public void setComponentA(ComponentA componentA) {
        this.componentA = componentA;
    }

    public void setComponentB(ComponentB componentB) {
        this.componentB = componentB;
    }

    /**
     * 参与者只负责通知中介，具体如何操作，中介来决定
     * @param msg
     * @param component
     */
    @Override
    public void notify(String msg, Component component) {
        if(component==componentA){
            componentB.getMsg(msg);
        }else {
            componentA.getMsg(msg);
        }
    }
}

/**
 * 参与者抽象类
 */
abstract class Component{
    public String name;
    public Mediator mediator;

    public Component(String name, Mediator mediator) {
        this.name = name;
        this.mediator = mediator;
    }
}

/**
 * 参与者A
 */
class ComponentA extends Component{
    public ComponentA(String name, Mediator mediator) {
        super(name, mediator);
    }
    public void getMsg(String msg){
        System.out.println(this.name+"获取消息:"+msg);
    }
    public void sendMsg(String msg){
        mediator.notify(msg,this);
    }

}

/**
 * 参与者B
 */
class ComponentB extends Component{
    public ComponentB(String name, Mediator mediator) {
        super(name, mediator);
    }
    public void getMsg(String msg){
        System.out.println(this.name+"获取消息:"+msg);
    }
    public void sendMsg(String msg){
        mediator.notify(msg,this);
    }

}
