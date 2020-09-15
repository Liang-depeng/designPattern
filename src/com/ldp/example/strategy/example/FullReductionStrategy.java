package com.ldp.example.strategy.example;

/**
 * 一种策略算法 假定 每满300减30
 */
public class FullReductionStrategy extends ShopStrategy {

    private double price1;
    private double price2;

    public FullReductionStrategy(double price1, double price2) {
        this.price1 = price1;
        this.price2 = price2;
    }

    @Override
    public double getResult() {
        double price = getTotalPrice();
        double amount;
        if (price < price1) {
            return price;
        }
        return price - (int) price / price1 * price2 + price % price1;
    }
}
