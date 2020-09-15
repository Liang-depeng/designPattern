package com.ldp.example.factory.example;

import java.util.Scanner;

/**
 * 工厂模式 计算器 举例测试
 */
public class OperationTest {

    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);
        double num1 = input.nextDouble();
        String operation = input.next();
        double num2 = input.nextDouble();

        Operation op1 = OperationFactory.creationOperate(operation);
        op1.setNum1(num1);
        op1.setNum2(num2);
        double result = op1.getResult();

        System.out.println(result);
    }
}
