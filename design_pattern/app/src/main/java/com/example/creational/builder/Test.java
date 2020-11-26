package com.example.creational.builder;

import java.util.Set;

public class Test {
    public static void main(String[] args) {
        Course course = new Course.CourseBuilder().buildCourseArticle("course-article").buildCoursePPT("course-ppt").build();
        System.out.println(course.toString());

    }
}
