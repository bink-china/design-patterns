package com.facade;

/**
 * 外观模式
 */
public class FacadePatterns {
    public static void main(String[] args) {
        new Facade().method();
    }
}

/**
 * 外观类
 */
class Facade{
    private SubSystem1 subSystem1 = new SubSystem1();
    private SubSystem2 SubSystem2 = new SubSystem2();
    private SubSystem3 SubSystem3 = new SubSystem3();

    public boolean method(){
        return subSystem1.methodA()&&SubSystem2.methodB()&&SubSystem3.methodC();
    }
}

/**
 * 子系统1
 */
class SubSystem1{
    public boolean methodA(){
        return true;
    }
}

/**
 * 子系统2
 */
class SubSystem2{
    public boolean methodB(){
        return true;
    }
}

/**
 * 子系统3
 */
class SubSystem3{
    public boolean methodC(){
        return true;
    }
}
