package com.example.creational.singleton;

public class HungrySingleton {
    private final static HungrySingleton hungrySingleton = new HungrySingleton();
    private HungrySingleton() {
        if (hungrySingleton != null) {
            // 通过反射调用时抛出异常
        }
    }
    public static HungrySingleton getInstance() {
        return  hungrySingleton;
    }
    private Object readResolve() {
        return hungrySingleton;
    }
}
