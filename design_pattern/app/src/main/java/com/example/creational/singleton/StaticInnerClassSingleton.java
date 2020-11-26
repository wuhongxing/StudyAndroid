package com.example.creational.singleton;

public class StaticInnerClassSingleton {
    // InnerClass 初始化的时候有锁
    private static class InnerClass {
        private static StaticInnerClassSingleton staticInnerClassSingleton = new StaticInnerClassSingleton();
    }

    public static StaticInnerClassSingleton getInstance() {
        return InnerClass.staticInnerClassSingleton;
    }

    private StaticInnerClassSingleton() {
    }
}
