package com.example.design_pattern.singleresponsibility;

public class Bird {
    public void mainMoveMode(String birdName) {
        // V1 版本
        if (birdName.equals("驼鸟")) {
            System.out.println(birdName + "用脚走");
        } else {
            System.out.println(birdName + "用翅膀飞");
        }
    }
}
