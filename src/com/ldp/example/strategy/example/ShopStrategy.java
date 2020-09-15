package com.ldp.example.strategy.example;

public abstract class ShopStrategy {

    private double totalPrice;

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public abstract double getResult();
}
