package com.example.behavioral.strange;

public class LijianPromotionStrategy implements PromotionStrategy {
    @Override
    public void doPromotion() {
        System.out.println("执行立减策略");
    }
}
