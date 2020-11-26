package com.example.structural.proxy.demo04;

import com.example.structural.proxy.demo2.IUserService;
import com.example.structural.proxy.demo2.UserServiceImpl;

public class Client {
    public static void main(String[] args) {
        // 真实角色
        UserServiceImpl userService = new UserServiceImpl();
        // 代理角色，不存在
        ProxyInvocationHandler pih = new ProxyInvocationHandler();
        pih.setTarget(userService);
        IUserService proxy = (IUserService) pih.getProxy();
        proxy.add();
    }
}
