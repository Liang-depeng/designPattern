package com.ldp.example.strategy;

import java.util.Scanner;

/**
 * 在策略模式（Strategy Pattern）中，一个类的行为或其算法可以在运行时更改。这种类型的设计模式属于行为型模式。
 * <p>
 * 在策略模式中，我们创建表示各种策略的对象和一个行为随着策略对象改变而改变的 context 对象。策略对象改变 context 对象的执行算法
 */
public class StrategyClass {

    /**
     * ---1--- 策略行为的公共接口
     */
    public interface IOperationStrategy {
        int doOperation(int num1, int num2);
    }

    /**
     * 不同的实现策略
     */
    public static class OperationAdd implements IOperationStrategy {

        @Override
        public int doOperation(int num1, int num2) {
            return num1 + num2;
        }
    }

    public static class OperationSub implements IOperationStrategy {

        @Override
        public int doOperation(int num1, int num2) {
            return num1 - num2;
        }
    }

    public static class OperationMul implements IOperationStrategy {

        @Override
        public int doOperation(int num1, int num2) {
            return num1 * num2;
        }
    }

    public static class OperationDiv implements IOperationStrategy {

        @Override
        public int doOperation(int num1, int num2) {
            return num1 / num2;
        }
    }

    /**
     * 要执行操作的类  需要根据对应策略 动态调整结果
     */
    public static class Operate {

        private IOperationStrategy strategy;

        // 选择策略 设置策略
        public Operate(IOperationStrategy strategy) {
            this.strategy = strategy;
        }

        public void setStrategy(IOperationStrategy strategy) {
            this.strategy = strategy;
        }

        public int executeStrategy(int num1, int num2) {
            return strategy.doOperation(num1, num2);
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int num1 = input.nextInt();
        int num2 = input.nextInt();

        Operate operate = new Operate(new OperationAdd());
        System.out.println("动态可配置 策略： +  "+operate.executeStrategy(num1,num2));

        operate.setStrategy(new OperationSub());
        System.out.println("动态可配置 策略： -  "+operate.executeStrategy(num1,num2));

        operate.setStrategy(new OperationMul());
        System.out.println("动态可配置 策略： *  "+operate.executeStrategy(num1,num2));

        operate.setStrategy(new OperationDiv());
        System.out.println("动态可配置 策略： /  "+operate.executeStrategy(num1,num2));
    }
}
