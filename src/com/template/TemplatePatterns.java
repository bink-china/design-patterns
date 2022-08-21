package com.template;

/**
 * 模板方法
 */
public class TemplatePatterns {
    public static void main(String[] args) {
        Template template = new TemplateA();
        template.templateMethod();
    }
}

/**
 * 模板抽象类
 */
abstract class Template {
    /**
     * 模板定义了执行过程，具体的实现由子类实现
     */
    public void templateMethod() {
        this.step1();
        this.step2();
        this.step3();
    }

    protected abstract void step1();

    protected abstract void step2();

    protected abstract void step3();
}

/**
 * 模板类A
 */
class TemplateA extends Template {
    @Override
    protected void step1() {
        System.out.println("TemplateA-step1");
    }

    @Override
    protected void step2() {
        System.out.println("TemplateA-step2");
    }

    @Override
    protected void step3() {
        System.out.println("TemplateA-step3");
    }
}

/**
 * 模板类B
 */
class TemplateB extends Template {
    @Override
    protected void step1() {
        System.out.println("TemplateB-step1");
    }

    @Override
    protected void step2() {
        System.out.println("TemplateB-step2");
    }

    @Override
    protected void step3() {
        System.out.println("TemplateB-step3");
    }
}