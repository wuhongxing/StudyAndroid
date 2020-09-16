package com.example.annotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Test09 {
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException, NoSuchFieldException {
        Class c1 = Class.forName("com.example.annotation.User");
        // 构造一个对象
        User user = (User) c1.newInstance();
        System.out.println(user);

        // 通过构造器创建对象
        Constructor constructor = c1.getDeclaredConstructor(String.class, int.class, int.class);
        User user2 = (User)constructor.newInstance("测试", 001, 18);
        System.out.println(user2);

        // 通过反射调用普通方法
        User user3 = (User)c1.newInstance();
        Method setName = c1.getDeclaredMethod("setName", String.class);
        setName.invoke(user3, "测试");
        System.out.println(user3);

        User user4 = (User)c1.newInstance();
        Field name = c1.getDeclaredField("name");
        // 不能直接操作私有属性，我们需要关闭程序的安全检测
        name.setAccessible(true);
        name.set(user4, "直接");
        System.out.println(user4.getName());
    }
}
