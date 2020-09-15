package com.ldp.example.strategy.example;

import java.util.Scanner;

public class ShopTest {
    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);
        double price = input.nextDouble();

        CashContext context = new CashContext("每满300减30");
        double totalPrice = context.getResultTotalPrice(price);
        System.out.println(totalPrice);
    }
}
