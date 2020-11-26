package com.example.structural.decorator;

import com.example.structural.decorator.v2.Battercake;
import com.example.structural.decorator.v2.ABattercake;
import com.example.structural.decorator.v2.EggDecorator;
import com.example.structural.decorator.v2.SausageDecorator;

public class Test {
    public static void main(String[] args) {
        // V1
//        Battercake battercake = new Battercake();
//        System.out.println(battercake.getDesc()+battercake.cost());
//
//        BattercakeWithEgg battercakeWithEgg = new BattercakeWithEgg();
//        System.out.println(battercakeWithEgg.getDesc()+battercakeWithEgg.cost());
//
//        BattercakeWithSausage battercakeWithSausage = new BattercakeWithSausage();
//        System.out.println(battercakeWithSausage.getDesc()+battercakeWithSausage.cost());

        // V2
        ABattercake aBattercake;
        aBattercake = new Battercake();
        aBattercake = new EggDecorator(aBattercake);
        aBattercake = new EggDecorator(aBattercake);
        aBattercake = new SausageDecorator(aBattercake);
        System.out.println(aBattercake.getDesc()+aBattercake.cost());
    }
}
