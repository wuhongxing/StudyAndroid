package com.example.behavioral.strange;

public class PromotionActivity {
    private PromotionStrategy promotionStrategy;

    public PromotionActivity(PromotionStrategy promotionStrategy) {
        this.promotionStrategy = promotionStrategy;
    }

    void executePromotionStrategy() {
        promotionStrategy.doPromotion();
    }
}
