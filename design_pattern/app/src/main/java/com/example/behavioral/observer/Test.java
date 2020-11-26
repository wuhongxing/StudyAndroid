package com.example.behavioral.observer;

public class Test {
    public static void main(String[] args) {
        Course course = new Course("Java 设计模式精讲");
        Teacher teacher = new Teacher("Alpha");

        Question question = new Question("Geely", "Java 的主函数如何编写");
        course.produceQuestion(course, question);
    }
}
