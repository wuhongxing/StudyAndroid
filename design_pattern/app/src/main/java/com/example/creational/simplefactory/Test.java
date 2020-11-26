package com.example.simplefactory;

public class Test {
    public static void main(String[] args) {
//        Video video = new JavaVideo();
//        video.produce();
//
//        Video video1 = new PythonVideo();
//        video1.produce();

        VideoFactory videoFactory = new VideoFactory();
        Video video = videoFactory.getVideo("java");
        if (video == null) return;
        video.produce();
    }
}
