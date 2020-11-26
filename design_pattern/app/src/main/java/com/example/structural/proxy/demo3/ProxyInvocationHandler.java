package com.example.structural.proxy.demo3;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

// InvocatioinHandler 是由代理实例的调用处理程序实现的接口
// Proxy 提供了创建动态代理类和实例的静态方法
public class ProxyInvocationHandler implements InvocationHandler {

    private IRent rent;

    public void setRent(IRent rent) {
        this.rent = rent;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        // 动态代理的本质就是使用反射机制实现！
        seeHouse();
        Object result = method.invoke(rent, args);
        return result;
    }

    private void seeHouse() {
        System.out.println("收中介费");
    }

    public Object getProxy() {
        return Proxy.newProxyInstance(this.getClass().getClassLoader(), rent.getClass().getInterfaces(), this);
    }
}
