package com.example.structural.proxy.demo01;

public class Proxy implements IRent {
    private Host host;

    public Proxy(Host host) {
        this.host = host;
    }

    @Override
    public void rent() {
        host.rent();
    }

    public void seeHouse() {
        System.out.println("中介带你看房");
    }

    public void fare() {
        System.out.println("收中介费");
    }
}
