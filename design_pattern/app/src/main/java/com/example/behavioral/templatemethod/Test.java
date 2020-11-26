package com.example.behavioral.templatemethod;

public class Test {
    public static void main(String[] args) {
        ACourse designPatternCourse = new DesignPatternCourse();
        designPatternCourse.makeCourse();

        ACourse feCourse = new FECourse();
        feCourse.makeCourse();
    }
}
