package com.ldp.example.strategy.example;

/**
 * 一种策略算法 假定 打8折
 */
public class DiscountStrategy extends ShopStrategy {

    private double discount;

    public DiscountStrategy(double discount) {
        this.discount = discount / 10;
    }

    @Override
    public double getResult() {
        return getTotalPrice() * discount;
    }
}
