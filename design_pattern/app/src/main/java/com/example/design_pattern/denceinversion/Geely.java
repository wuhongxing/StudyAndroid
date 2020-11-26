package com.example.design_pattern.denceinversion;

public class Geely {
    private ICourse iCourse;
    // V4 版本
    public Geely() {

    }
    public void setiCourse(ICourse iCourse) {
        this.iCourse = iCourse;
    }

    // V3 版本
    public Geely(ICourse iCourse) {
        this.iCourse = iCourse;
    }

    public void studyCourse() {
        iCourse.studyCourse();
    }

    // V2 版本
//    public void studyCourse(ICourse iCourse) {
//        iCourse.studyCourse();
//    }

    // V1 版本
//    public void studyJavaCourse() {
//        System.out.println("Geely 在学习 Java 课程");
//    }
//
//    public void studyCCourse() {
//        System.out.println("Geely 在学习 C 课程");
//    }
//
//    public void studyPythonCourse() {
//        System.out.println("Geely 在学习 Python 课程");
//    }
}


