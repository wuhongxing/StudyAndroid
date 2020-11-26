package com.example.behavioral.chainofresponsibility;

import android.text.TextUtils;

public class VideoApprover extends Approver {
    @Override
    public void deploy(Course course) {
        if (!course.getVideo().isEmpty()) {
            System.out.println(course.getName() + "含有视频，批准");
            if (approver != null) {
                approver.deploy(course);
            }
        } else {
            System.out.println(course.getName() + "不含有视频，不批准，流程结束");
            return;
        }
    }
}
