package com.state;

/**
 * 状态模式
 */
public class StatePatterns {
    public static void main(String[] args) {
        Content content = new Content();
        content.setState(new StateA());
        content.contentMethod();
        content.setState(new StateB());
        content.contentMethod();
    }
}

/**
 * 环境对象
 */
class Content{
    State state = null;

    /**
     * 修改状态
     * @param state
     */
    public void setState(State state) {
        this.state = state;
    }

    public void contentMethod(){
        this.state.method();
    }
}

/**
 * 状态接口
 */
interface State{
    public void method();
}

/**
 * 状态A
 */
class StateA implements State{
    @Override
    public void method() {
        System.out.println("状态A方法");
    }
}

/**
 * 状态B
 */
class StateB implements State{
    @Override
    public void method() {
        System.out.println("状态B方法");
    }
}