package com.ldp.example.factory;

import java.util.Scanner;

/**
 * 工厂模式（Factory Pattern）是 Java 中最常用的设计模式之一。这种类型的设计模式属于创建型模式，它提供了一种创建对象的最佳方式。
 * <p>
 * 在工厂模式中，我们在创建对象时不会对客户端暴露创建逻辑，并且是通过使用一个共同的接口来指向新创建的对象。
 * <p>
 * 注意事项：作为一种创建类模式，在任何需要生成复杂对象的地方，都可以使用工厂方法模式。有一点需要注意的地方就是复杂对象适合使用工厂模式，
 * 而简单对象，特别是只需要通过 new 就可以完成创建的对象，无需使用工厂模式。如果使用工厂模式，就需要引入一个工厂类，会增加系统的复杂度
 */
public class FactoryClass {

    /**
     * 第一步 创建一个接口 或者 抽象类
     * --- 当创建的对象有一些公共属性 可以用抽象类 根据具体情况选用
     */
    public interface IPerson {
        void work();
    }

    public static abstract class Person {

        public String name;
        public int age;
        public String sex;

        public abstract void work();

    }

    // 抽象类实现  或者接口实现 需要的对象实体类
    public static class Student extends Person {
        @Override
        public void work() {
            System.out.println("student---上学");
        }
    }

    public static class Worker extends Person {
        @Override
        public void work() {
            System.out.println("worker---上班");
        }
    }

    public static class Teacher extends Person {
        @Override
        public void work() {
            System.out.println("teacher---教书");
        }
    }

    public static class Doctor extends Person {
        @Override
        public void work() {
            System.out.println("doctor---看病");
        }
    }

    // ...

    /**
     * 创建一个工厂，生成基于给定信息的实体类的对象。
     */
    public static class Factory {

        public Person getPerson(String personType) throws Exception {
            Person person = null;
            switch (personType) {
                case "student":
                    person = new Student();
                    break;
                case "worker":
                    person = new Worker();
                    break;
                case "teacher":
                    person = new Teacher();
                    break;
                case "doctor":
                    person = new Doctor();
                    break;
                default:
                    throw new Exception("未找到对应职业");
            }
            return person;
        }
    }

    /**
     * 使用该工厂，通过传递类型信息来获取实体类的对象。
     */
    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);
        Factory factory = new Factory();
        Person person = factory.getPerson(input.next());
        person.work();

    }

    // 接口实现  
    public class Worker2 implements IPerson {
        @Override
        public void work() {
        }
    }
}
