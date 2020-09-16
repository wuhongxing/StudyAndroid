package com.example.butterknife;

import android.view.View;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Method;

@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@BaseEvent(listenerSetter = "setOnClickListener",
listenerType = View.OnClickListener.class,
callBackMethod = "onClick")
public @interface MyOnClick {
    int[] value();
}

@Target({ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@interface BaseEvent {
    String listenerSetter();
    Class<?> listenerType();
    String callBackMethod();
}
