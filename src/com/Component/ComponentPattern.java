package com.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * 组合模式
 */
public class ComponentPattern {
    public static void main(String[] args) {
        Laef laef1 = new Laef("节点1");
        Laef laef2 = new Laef("节点2");
        Composite composite = new Composite();
        composite.add(laef1);
        composite.add(laef2);

        Composite children = new Composite();
        children.add(new Laef("节点3"));
        composite.add(children);

        composite.execute();

    }
}

/**
 * 组合接口
 */
interface Component{
    void execute();
}

/**
 * 节点
 */
class Laef implements Component{
    String name;

    public Laef(String name) {
        this.name = name;
    }

    /**
     * 具体执行操作
     */
    @Override
    public void execute() {
        System.out.println(name+"执行具体操作");
    }
}

/**
 * 容器
 */
class Composite implements Component{
    List<Component> children = new ArrayList<>();
    @Override
    public void execute() {
        for (Component child : children) {
            child.execute();
        }
    }

    public void add(Component component){
        children.add(component);
    }

    public void remove(Component component){
        children.remove(component);
    }

    public List<Component> getChildren() {
        return children;
    }


}