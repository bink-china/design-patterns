package com;

/**
 * 责任链模式
 */
public class ChainPatterns {
    public static void main(String[] args) {
        Handles a = new HandlesA();
        Handles b = new HandlesB();
        Handles c = new HandlesC();
        a.setNextHandles(b).setNextHandles(c);
        a.process(20);
    }
}

/**
 * 责任链抽象
 */
abstract class Handles{
    Handles nextHandles = null;
    public Handles setNextHandles(Handles nextHandles) {
        this.nextHandles = nextHandles;
        return this.nextHandles;
    }
    abstract void process(Integer info);
}

/**
 * 责任链A
 */
class HandlesA extends Handles{
    @Override
    void process(Integer info)  {
        if(info<10){
            System.out.println("HandlesA 处理");
        }else {
            this.nextHandles.process(info);
        }
    }
}
/**
 * 责任链B
 */
class HandlesB extends Handles{
    @Override
    void process(Integer info)  {
        if(info<20){
            System.out.println("HandlesB 处理");
        }else {
            this.nextHandles.process(info);
        }
    }
}
/**
 * 责任链C
 */
class HandlesC extends Handles{
    @Override
    void process(Integer info)  {
        if(info<30){
            System.out.println("HandlesC 处理");
        }else {
            this.nextHandles.process(info);
        }
    }
}


