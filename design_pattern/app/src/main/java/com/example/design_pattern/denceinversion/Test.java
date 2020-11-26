package com.example.design_pattern.denceinversion;

public class Test {
    public static void main(String[] args) {
        // V1 版本
//        Geely geely = new Geely();
//        geely.studyCCourse();
//        geely.studyJavaCourse();

        // V2 版本
//        Geely geely = new Geely();
//        geely.studyCourse(new JavaCourse());
//        geely.studyCourse(new CCourse());

        // V3 版本
//        Geely geely = new Geely(new JavaCourse());
//        geely.studyCourse();
//        Geely geely1 = new Geely(new CCourse());
//        geely1.studyCourse();

        // V4 版本
        Geely geely = new Geely();
        geely.setiCourse(new JavaCourse());
        geely.studyCourse();
        geely.setiCourse(new CCourse());
        geely.studyCourse();
    }
}
