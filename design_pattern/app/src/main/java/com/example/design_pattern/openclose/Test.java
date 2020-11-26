package com.example.design_pattern.openclose;

public class Test {
    public static void main(String[] args) {
        ICourse iCourse = new JavaDiscountCourse(100, "java", 348.0);
        JavaDiscountCourse javaDiscountCourse = (JavaDiscountCourse)iCourse;
        System.out.println(javaDiscountCourse.getId().toString() + javaDiscountCourse.getName() + javaDiscountCourse.getPrice().toString() + javaDiscountCourse.getOriginPrice().toString());
    }
}
