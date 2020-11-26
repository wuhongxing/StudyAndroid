package com.example.behavioral.templatemethod;

public class FECourse extends ACourse {
    @Override
    boolean needWriteArticle() {
        return false;
    }

    @Override
    void packageCourse() {
        System.out.println("FECourse package");
    }
}
