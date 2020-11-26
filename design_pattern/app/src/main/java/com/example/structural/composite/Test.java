package com.example.structural.composite;

public class Test {
    public static void main(String[] args) {
        CatalogComponent linuxCourse = new Course("Linux 课程");
        CatalogComponent windowsCourse = new Course("Windows 课程");

        CatalogComponent javaCourseCatalog = new CourseCatalog("Java 目录");
        CatalogComponent course1 = new Course("Windows 课程-1");
        CatalogComponent course2 = new Course("Windows 课程-2");
        javaCourseCatalog.add(course1);
        javaCourseCatalog.add(course2);
        javaCourseCatalog.print();

    }
}
