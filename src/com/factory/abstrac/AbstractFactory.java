package com.factory.abstrac;

/**
 * 抽象工厂类
 */
public class AbstractFactory {

    public static void main(String[] args) {
        Factory factory = new FactoryBB();
        Phone phone = factory.getPhone();
        phone.method();
        Book book = factory.getBook();
        book.method();
    }

    /**
     * 抽象工厂类
     */
    static abstract class Factory{
        abstract Phone getPhone();
        abstract Book getBook();
    }

    /**
     * 具体工厂A
     */
    static class FactoryAA extends Factory{
        @Override
        Phone getPhone() {
            return new PhoneA();
        }

        @Override
        Book getBook() {
            return new BookA();
        }
    }

    /**
     * 具体工厂B
     */
    static class FactoryBB extends Factory{
        @Override
        Phone getPhone() {
            return new PhoneB();
        }

        @Override
        Book getBook() {
            return new BookB();
        }
    }

    /**
     * 抽象产品类 Phone
     */
    static abstract class Phone{
        abstract void method();
    }

    /**
     * 产品PhoneA
     */
    static class PhoneA extends Phone{
        @Override
        void method() {
            System.out.println("PhoneA");
        }
    }

    /**
     * 产品PhoneB
     */
    static class PhoneB extends Phone{
        @Override
        void method() {
            System.out.println("PhoneB");
        }
    }


    /**
     * 抽象产品类 Book
     */
    static abstract class Book{
        abstract void method();
    }

    /**
     * 产品BookA
     */
    static class BookA extends Book{
        @Override
        void method() {
            System.out.println("BookA");
        }
    }

    /**
     * 产品BookB
     */
    static class BookB extends Book{
        @Override
        void method() {
            System.out.println("BookB");
        }
    }
}
