package com.example.structural.decorator.v2;

public class EggDecorator extends AbstractDecorator {

    public EggDecorator(ABattercake aBattercake) {
        super(aBattercake);
    }

    @Override
    public String getDesc() {
        return super.getDesc() + "加一个鸡蛋";
    }

    @Override
    public int cost() {
        return super.cost() + 1;
    }
}
