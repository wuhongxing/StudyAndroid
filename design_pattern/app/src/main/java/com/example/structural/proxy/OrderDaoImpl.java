package com.example.structural.proxy;

public class OrderDaoImpl implements IOrderDao {

    @Override
    public int insert(Order order) {
        System.out.println("插入数据库成功");
        return 0;
    }
}
