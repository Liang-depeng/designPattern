package com.ldp.example.factory.example;

import java.math.BigDecimal;

public class OperationDiv extends Operation {

    @Override
    public double getResult() {
        BigDecimal num1 = BigDecimal.valueOf(getNum1());
        BigDecimal num2 = BigDecimal.valueOf(getNum2());
        BigDecimal result = num1.divide(num2, 2, BigDecimal.ROUND_HALF_UP);
        return result.doubleValue();
    }
}
