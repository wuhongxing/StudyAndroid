package com.example.behavioral.observer;

import java.util.Observable;
import java.util.Observer;

public class Teacher implements Observer {
    private String teacherName;

    public Teacher(String teacherName) {
        this.teacherName = teacherName;
    }

    @Override
    public void update(Observable observable, Object o) {
        Course course = (Course)observable;
        Question question = (Question)o;
        System.out.println(teacherName + "老师的" + course.getCourseName() + "课程有一个新提问");
    }
}
