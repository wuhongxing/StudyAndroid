package com.example.structural.proxy.demo01;

public class Host implements IRent {
    @Override
    public void rent() {
        System.out.println("房东要出租房子");
    }
}
