package com.ldp.example.factory.example;

import java.math.BigDecimal;

public class OperationAdd extends Operation {

    @Override
    public double getResult() {
        return BigDecimal.valueOf(getNum1()).add(BigDecimal.valueOf(getNum2())).doubleValue();
    }
}
