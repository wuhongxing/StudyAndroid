package com.example.behavioral.chainofresponsibility;

public class Test {
    public static void main(String[] args) {
        Approver articleApprover = new ArticleApprover();
        Approver videoApprover = new VideoApprover();

        Course course = new Course();
        course.setName("java");
        course.setArticle("java-article");
        course.setVideo("java-video");

        articleApprover.setNextApprover(videoApprover);
        articleApprover.deploy(course);
    }
}
