package com.example.annotation;

public class Test06 {
    static {
        System.out.println("Main 类被加载");
    }

    public static void main(String[] args) throws ClassNotFoundException {
//        Son son = new Son();
//        Class.forName("com.example.annotation.Test06");
//        int m = Son.m;
//        int m1 = Son.M;
        int b = Son.b;
    }
}

class Father {
    static int b = 10;
    static {
        System.out.println("父类被加载");
    }
}

class Son extends Father {
    static {
        System.out.println("子类被加载");
        m = 300;
    }
    static int m = 100;
    static  final int M = 1;
}
