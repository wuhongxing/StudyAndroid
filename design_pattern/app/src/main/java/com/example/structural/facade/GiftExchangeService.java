package com.example.structural.facade;

public class GiftExchangeService {
    private PointsPaymentService pointsPaymentService = new PointsPaymentService();
    private QualifyService qualifyService = new QualifyService();
    private ShippingService shippingService = new ShippingService();

//    public void setPointsPaymentService(PointsPaymentService pointsPaymentService) {
//        this.pointsPaymentService = pointsPaymentService;
//    }
//
//    public void setQualifyService(QualifyService qualifyService) {
//        this.qualifyService = qualifyService;
//    }
//
//    public void setShippingService(ShippingService shippingService) {
//        this.shippingService = shippingService;
//    }

    public void giftExchange(PointsGift pointsGift) {
        if (qualifyService.isAvailable(pointsGift)) {
            if (pointsPaymentService.pay(pointsGift)) {
                System.out.println("物流系统下单成功"+shippingService.shipGift(pointsGift));
            }
        }
    }
}
