package com.example.behavioral.strange;

public class ManjianPromotionStrategy implements PromotionStrategy {
    @Override
    public void doPromotion() {
        System.out.println("执行满减策略");
    }
}
