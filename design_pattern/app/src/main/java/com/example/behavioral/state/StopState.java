package com.example.behavioral.state;

public class StopState extends CourseVideoState {
    @Override
    public void play() {
        super.courseVideoContext.setCourseVideoState(CourseVideoContext.PLAY_STATE);
    }

    @Override
    public void speed() {
        System.out.println("不能快进");
    }

    @Override
    public void pause() {
        System.out.println("不能暂停");
    }

    @Override
    public void stop() {
        System.out.println("停止视频");
    }
}
