package com.ldp.example.strategy.example;

/**
 * 一种策略算法 假定 满1000减150
 */
public class FullReduction2Strategy extends ShopStrategy {

    private double price1;
    private double price2;

    public FullReduction2Strategy(double price1, double price2) {
        this.price1 = price1;
        this.price2 = price2;
    }

    @Override
    public double getResult() {
        double totalPrice = getTotalPrice();
        if (totalPrice < price1)
            return totalPrice;
        return totalPrice - price2;
    }
}
