package com.ldp.example.strategy.example;

/**
 * 策略模式 和 简单工厂模式 相结合
 */
public class CashContext {

    private ShopStrategy strategy;

    public CashContext(String shopStrategyType) throws Exception {

        switch (shopStrategyType) {
            case "打8折":
                strategy = new DiscountStrategy(8);
                break;
            case "每满300减30":
                strategy = new FullReductionStrategy(300, 30);
                break;
            case "满1000减150":
                strategy = new FullReduction2Strategy(1000, 150);
                break;
            case "满1000减500":
                strategy = new FullReduction2Strategy(1000, 500);
                break;
            default:
                throw new Exception("未找到的活动！！");
        }
    }

    public double getResultTotalPrice(double total) {
        if (strategy != null) {
            strategy.setTotalPrice(total);
            return strategy.getResult();
        }
        return 0;
    }
}
