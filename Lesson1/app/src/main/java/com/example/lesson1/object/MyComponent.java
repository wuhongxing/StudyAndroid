package com.example.lesson1.object;

import com.example.lesson1.MainActivity;

import dagger.Component;

// 一个组件，用来注入对象到其它类中

@Component(modules = {DatabaseModule.class, HttpModule.class})
public interface MyComponent {
    // 参数是不能用 Object T 多态，只能用于指定类
    void inject(MainActivity mainActivity);
}
