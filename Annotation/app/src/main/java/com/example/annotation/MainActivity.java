package com.example.annotation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        test1();
        Class c1 = null;
        Class c2 = null;
        try {
            c1 = Class.forName("com.example.annotation.User");
            c2 = Class.forName("com.example.annotation.User");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        User user = new User();
        System.out.println("------------------");
        System.out.println(c1.hashCode());
        System.out.println(c2.hashCode());
        System.out.println(User.class.hashCode());
        System.out.println(user.getClass().hashCode());
    }

    @MyAnnotation
    public void test() {
        System.out.print("test");
    }

    @MyAnnotation1
    public void test1() {

    }

    @MyAnnotation2("默认")
    public void test2() {

    }
}

@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@interface MyAnnotation2 {
    String value();
}


