package com.example.structural.decorator.v2;

public class Battercake extends ABattercake {
    @Override
    public String getDesc() {
        return "剩饭";
    }

    @Override
    public int cost() {
        return 5;
    }
}
