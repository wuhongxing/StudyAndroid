package com.example.behavioral.strange;

import android.text.TextUtils;

public class Test {
//    public static void main(String[] args) {
//        PromotionActivity promotionActivity618 = new PromotionActivity(new LijianPromotionStrategy());
//        PromotionActivity promotionActivity1111 = new PromotionActivity(new FanxianPromotionStrategy());
//
//        promotionActivity618.executePromotionStrategy();
//        promotionActivity1111.executePromotionStrategy();
//    }

//    public static void main(String[] args) {
//        PromotionActivity promotionActivity = null;
//        String promotionKey = "LIJIAN";
//
//        if (promotionKey.equals("LIJIAN")) {
//            promotionActivity = new PromotionActivity(new LijianPromotionStrategy());
//        } else if (promotionKey.equals("FANXIAN")) {
//            promotionActivity = new PromotionActivity(new FanxianPromotionStrategy());
//        } else if (promotionKey.equals("MANJIAN")) {
//            promotionActivity = new PromotionActivity(new ManjianPromotionStrategy());
//        }
//        promotionActivity.executePromotionStrategy();
//    }

    public static void main(String[] args) {
        String promotionKey = "MANJIANX";
        PromotionActivity promotionActivity = new PromotionActivity(PromotionStrategyFactory.getPromotionStrategy(promotionKey));
        promotionActivity.executePromotionStrategy();
    }
}
