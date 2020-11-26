package com.example.structural.facade;

public class PointsPaymentService {
    public boolean pay(PointsGift pointsGift) {
        System.out.println("支付"+pointsGift.getName()+"成功");
        return true;
    }
}
