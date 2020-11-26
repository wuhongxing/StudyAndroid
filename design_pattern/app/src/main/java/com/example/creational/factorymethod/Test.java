package com.example.creational.factorymethod;

public class Test {
    public static void main(String[] args) {
        VideoFactory videoFactory = new JavaVideoFactory();
        videoFactory.getVideo().produce();
    }
}
