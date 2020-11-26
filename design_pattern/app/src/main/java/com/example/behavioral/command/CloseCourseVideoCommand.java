package com.example.behavioral.command;

public class CloseCourseVideoCommand implements Command {
    private CourseVideo courseVideo;

    public CloseCourseVideoCommand(CourseVideo courseVideo) {
        this.courseVideo = courseVideo;
    }

    @Override
    public void execute() {
        courseVideo.close();
    }

    @Override
    public void undo() {
        courseVideo.open();
    }
}
