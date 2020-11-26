package com.example.structural.proxy.demo3;

public class Client {
    public static void main(String[] args) {
        Host host = new Host();
        ProxyInvocationHandler pih = new ProxyInvocationHandler();
        pih.setRent(host);
        IRent proxy = (IRent) pih.getProxy(); // 这里的 proxy 就是动态生成的，我们并没有写
        proxy.rent();
    }
}
