package com.builder;

/**
 * 生成器模式
 */
public class BuilderPatterns {
    public static void main(String[] args) {
        Car car = new Car.Builder().name("aaa").age(10).build();
        System.out.println(car);
    }
}

/**
 * 生成器模式
 */
class Car{
    private String name;
    private Integer age;

    public Car(Builder builder) {
        this.name = builder.name;
        this.age = builder.age;
    }

    @Override
    public String toString() {
        return "Car{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    /**
     * 建造者对象
     */
    static class Builder{
        private String name;
        private Integer age;

        public Builder name(String name){
            this.name = name;
            return this;
        }
        public Builder age(Integer age){
            this.age = age;
            return this;
        }

        /**
         * 生成目标对象
         * @return
         */
        public Car build(){
            return new Car(this);
        }
    }
}

