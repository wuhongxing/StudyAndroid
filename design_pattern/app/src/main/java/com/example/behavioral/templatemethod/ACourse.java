package com.example.behavioral.templatemethod;

public abstract class ACourse {
    final void makeCourse() {
        makePPT();
        makeVideo();
        if (needWriteArticle()) {
            writeArticle();
        }
        packageCourse();
    }

    final void makePPT() {
        System.out.println("制作 PPT");
    }

    final void makeVideo() {
        System.out.println("制作视频");
    }

    final void writeArticle() {
        System.out.println("编写手记");
    }

    boolean needWriteArticle() {
        return true;
    }

    abstract void packageCourse();
}
