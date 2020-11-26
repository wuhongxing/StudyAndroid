package com.example.structural.proxy;

public class OrderServiceImpl implements IOrderService {
    private IOrderDao iOrderDao;
    @Override
    public int saveOrder(Order order) {
        iOrderDao = new OrderDaoImpl();
        System.out.println("Service层调用Dao层调用Order");
        return iOrderDao.insert(order);
    }
}
