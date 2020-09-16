package com.example.annotation;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Test08 {
    public static void main(String[] args) throws ClassNotFoundException {
        Class c1 = Class.forName("com.example.annotation.User");
        System.out.println(c1.getName());
        System.out.println(c1.getSimpleName());

        Field[] fields = c1.getDeclaredFields();
        for (Field field: fields) {
            System.out.println(field);
        }

        Method[] methods = c1.getMethods();
        for (Method method: methods) {
            System.out.println(method);
        }


    }
}
