package com.example.creational.singleton;

public class DoubleCheckLazySingleton {
    private volatile static DoubleCheckLazySingleton lazySingleton = null;
    private DoubleCheckLazySingleton() {}

    public synchronized static DoubleCheckLazySingleton getInstance() {
        if (lazySingleton == null) {
            synchronized (DoubleCheckLazySingleton.class) {
                if (lazySingleton == null) {
                    lazySingleton = new DoubleCheckLazySingleton();
                    // 1. 分配内存给这个对象
                    // 2. 设置 lazySingleton 指向刚分配的内存地址
                    // 2. 初始化对象
                }
            }
        }
        return lazySingleton;
    }
}
