package com.example.structural.proxy.demo01;

public class Client {
    public static void main(String[] args) {
        Host host = new Host();
        Proxy proxy = new Proxy(host);
//        host.rent();
        proxy.seeHouse();
        proxy.fare();
        proxy.rent();
    }
}
