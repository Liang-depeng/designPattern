package com.ldp.example.factory.example;

public class OperationFactory {

    public static Operation creationOperate(String operate) throws Exception {
        Operation operation = null;
        switch (operate) {
            case "+":
                operation = new OperationAdd();
                break;
            case "-":
                operation = new OperationSub();
                break;
            case "*":
                operation = new OperationMul();
                break;
            case "/":
                operation = new OperationDiv();
                break;
            default:
                throw new Exception("未知运算符");
        }
        return operation;
    }
}
