package com.example.behavioral.chainofresponsibility;

public abstract class Approver {
    Approver approver;

    public void setNextApprover(Approver approver) {
        this.approver = approver;
    }

    public abstract void deploy(Course course);
}
