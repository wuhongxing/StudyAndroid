package com.example.design_pattern.singleresponsibility;

public class Test {
    public static void main(String[] args) {
//        Bird bird = new Bird();
//        bird.mainMoveMode("大雁");
//        bird.mainMoveMode("驼鸟");

        FlyBird flyBird = new FlyBird();
        flyBird.mainMoveMode("大雁");

        WalkBird walkBird = new WalkBird();
        walkBird.mainMoveMode("驼鸟");
    }
}
