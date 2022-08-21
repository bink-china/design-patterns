package com.strategy;

/**
 * 策略模式
 */
public class StrategyPatterns {
    public static void main(String[] args) {
        Content content = new Content();
        content.setStrategy(new StrategyA());
        content.contentMethod();
        content.setStrategy(new StrategyB());
        content.contentMethod();
    }
}

/**
 * 环境类
 */
class Content {
    /**
     * 策略
     */
    Strategy strategy = null;

    /**
     * 设置策略
     *
     * @param strategy
     */
    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }

    /**
     * 具体执行由策略负责
     */
    public void contentMethod() {
        strategy.method();
    }


}

/**
 * 策略接口
 */
interface Strategy {
    public void method();
}

/**
 * 策略A
 */
class StrategyA implements Strategy {
    @Override
    public void method() {
        System.out.println("策略A");
    }
}

/**
 * 策略A
 */
class StrategyB implements Strategy {
    @Override
    public void method() {
        System.out.println("策略B");
    }
}