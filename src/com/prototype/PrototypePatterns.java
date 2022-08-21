package com.prototype;

import java.io.*;

/**
 * 原型模式
 */
public class PrototypePatterns {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Prototype prototype = new ConcretePrototype();
        System.out.println(prototype.toString());
        Prototype clone = prototype.clone();
        System.out.println(clone.toString());

//        JdkClone jdkClone = new JdkClone();
//        System.out.println(jdkClone);
//        System.out.println(jdkClone.clone());

//        JdkDeepClone jdkDeepClone = new JdkDeepClone();
//        System.out.println(jdkDeepClone);
//        JdkDeepClone deepClone = jdkDeepClone.deepClone();
//        System.out.println(deepClone);
    }
}

/**
 * 原型接口
 */
interface Prototype {
    Prototype clone();
}

/**
 * 实现类
 */
class ConcretePrototype implements Prototype {
    private String name = "name" + Math.random();
    private String age = "age" + Math.random();

    public ConcretePrototype() {
    }

    public ConcretePrototype(ConcretePrototype concretePrototype) {
        this.name = concretePrototype.name;
        this.age = concretePrototype.age;
    }

    @Override
    public Prototype clone() {
        return new ConcretePrototype(this);
    }

    @Override
    public String toString() {
        return "ConcretePrototype{" +
                "name='" + name + '\'' +
                ", age='" + age + '\'' +
                '}';
    }
}

/**
 * jdk浅克隆实现方式
 */
class JdkClone implements Cloneable {
    @Override
    protected Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }
}

/**
 * 深克隆
 */
class JdkDeepClone implements Serializable{
    public JdkDeepClone deepClone() throws IOException, ClassNotFoundException {
        //序列化
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(bos);
        oos.writeObject(this);
        //反序列化
        ByteArrayInputStream bis = new ByteArrayInputStream(bos.toByteArray());
        ObjectInputStream ois = new ObjectInputStream(bis);
        JdkDeepClone clone = (JdkDeepClone) ois.readObject();
        return clone;
    }
}

/**
 * 测试深浅克隆用的对象
 */
class Obj implements Serializable{

}