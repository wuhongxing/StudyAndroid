package com.example.structural.facade;

public class Test {
    public static void main(String[] args) {
        PointsGift pointsGift = new PointsGift("T-shirt");
        GiftExchangeService giftExchangeService = new GiftExchangeService();
        // 这里如果发生交互的话就不是外观设置模式了
//        giftExchangeService.setPointsPaymentService(new PointsPaymentService());
//        giftExchangeService.setQualifyService(new QualifyService());
//        giftExchangeService.setShippingService(new ShippingService());
        giftExchangeService.giftExchange(pointsGift);
    }
}
