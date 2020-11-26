package com.example.design_pattern.demeter;

import java.util.ArrayList;
import java.util.List;

public class Boss {
    public void commandCheckNumber(TeamLeader teamLeader) {
//        List<Course> courseList = new ArrayList<>();
//        for (int i = 0; i < 20; i ++) {
//            courseList.add(new Course());
//        }
//        teamLeader.checkNumberOfCourses(courseList);

        // V2
        teamLeader.checkNumberOfCourses();
    }
}
