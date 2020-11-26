package com.example.creational.builder;

public class Course {
    private String courseName;
    private String coursePPT;
    private String courseVideo;
    private String courseArticle;

    public Course(CourseBuilder courseBuilder) {
        this.courseName = courseBuilder.courseName;
        this.coursePPT = courseBuilder.coursePPT;
        this.courseVideo = courseBuilder.courseVideo;
        this.courseArticle = courseBuilder.courseArticle;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCoursePPT() {
        return coursePPT;
    }

    public void setCoursePPT(String coursePPT) {
        this.coursePPT = coursePPT;
    }

    public String getCourseVideo() {
        return courseVideo;
    }

    public void setCourseVideo(String courseVideo) {
        this.courseVideo = courseVideo;
    }

    public String getCourseArticle() {
        return courseArticle;
    }

    public void setCourseArticle(String courseArticle) {
        this.courseArticle = courseArticle;
    }

    @Override
    public String toString() {
        return "Course{" +
                "courseName='" + courseName + '\'' +
                ", coursePPT='" + coursePPT + '\'' +
                ", courseVideo='" + courseVideo + '\'' +
                ", courseArticle='" + courseArticle + '\'' +
                '}';
    }

//    abstract class CourseBuilder {
//        abstract void buildCourseName(String courseName);
//        abstract void buildCoursePPT(String coursePPT);
//        abstract void buildCourseVideo(String courseVideo);
//        abstract void buildCourseArticle(String courseArticle);
//
//        abstract Course makeCourse();
//    }

    public static class CourseBuilder {
        private String courseName;
        private String coursePPT;
        private String courseVideo;
        private String courseArticle;

        CourseBuilder buildCourseName(String courseName) {
            this.courseName = courseName;
            return this;
        }

        CourseBuilder buildCoursePPT(String coursePPT) {
            this.coursePPT = coursePPT;
            return this;
        }

        CourseBuilder buildCourseVideo(String courseVideo) {
            this.courseVideo = courseVideo;
            return this;
        }

        CourseBuilder buildCourseArticle(String courseArticle) {
            this.courseArticle = courseArticle;
            return this;
        }

        Course build() {
            return new Course(this);
        }
    }
}
