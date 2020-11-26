package com.example.behavioral.strange;

public class FanxianPromotionStrategy implements PromotionStrategy {
    @Override
    public void doPromotion() {
        System.out.println("执行返现策略");
    }
}
