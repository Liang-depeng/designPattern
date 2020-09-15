package com.ldp.example.factory.example;

import java.math.BigDecimal;

public class OperationMul extends Operation {

    @Override
    public double getResult() {
        BigDecimal num1 = BigDecimal.valueOf(getNum1());
        BigDecimal num2 = BigDecimal.valueOf(getNum2());
        BigDecimal result = num1.multiply(num2);
        return result.doubleValue();
    }
}
