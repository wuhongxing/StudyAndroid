package com.example.structural.decorator.v1;

public class BattercakeWithSausage extends Battercake {
    @Override
    protected String getDesc() {
        return super.getDesc() + "加一根香肠";
    }

    @Override
    protected int cost() {
        return super.cost() + 2;
    }
}
