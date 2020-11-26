package com.example.design_pattern.singleresponsibility;

public interface ICourse {
    String getCourseName();
    byte[] getCourseVideo();

    void studyCourse();
    void refundCourse();
}
