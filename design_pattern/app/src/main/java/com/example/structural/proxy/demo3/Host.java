package com.example.structural.proxy.demo3;

public class Host implements IRent {
    @Override
    public void rent() {
        System.out.println("房东出租房屋");
    }
}
