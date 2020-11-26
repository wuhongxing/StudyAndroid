package com.example.structural.proxy.staticproxy;

import com.example.structural.proxy.IOrderService;
import com.example.structural.proxy.Order;
import com.example.structural.proxy.OrderServiceImpl;

public class OrderServiceStaticProxy {
    private IOrderService iOrderService;

    public int saveOrder(Order order) {
        beforeMethod();
        iOrderService = new OrderServiceImpl();
        int userId = order.getUserId();
        int dbRouter = userId % 2;
        afterMethod();
        return iOrderService.saveOrder(order);
    }

    public void setiOrderService(IOrderService iOrderService) {
        this.iOrderService = iOrderService;
    }

    private void beforeMethod() {
        System.out.println("静态代理 before code");
    }

    private void afterMethod() {
        System.out.println("静态代理 after code");
    }
}
