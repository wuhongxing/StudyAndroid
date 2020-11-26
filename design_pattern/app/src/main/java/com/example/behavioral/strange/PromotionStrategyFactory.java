package com.example.behavioral.strange;

import java.util.HashMap;
import java.util.Map;

public class PromotionStrategyFactory {
    private static Map<String, PromotionStrategy> map = new HashMap();
    static {
        map.put(PromotionKey.LIJIAN, new LijianPromotionStrategy());
        map.put(PromotionKey.MANJIAN, new ManjianPromotionStrategy());
        map.put(PromotionKey.FANXIAN, new FanxianPromotionStrategy());
    }

    private PromotionStrategyFactory() {

    }

    static PromotionStrategy getPromotionStrategy(String key) {
        PromotionStrategy promotionStrategy = map.get(key);
        return promotionStrategy == null ? new LijianPromotionStrategy() : promotionStrategy;
    }

    private interface PromotionKey {
        String LIJIAN = "LIJIAN";
        String MANJIAN = "MANJIAN";
        String FANXIAN = "FANXIAN";
    }
}
