package com.example.structural.adapter;

public class ConcreteTarget implements Target {
    @Override
    public void request() {
        System.out.println("concreteTarget 目标方法");
    }
}
