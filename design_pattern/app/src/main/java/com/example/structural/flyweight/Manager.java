package com.example.structural.flyweight;

public class Manager implements Employee {
    private String department;
    private String reportContent;

    public void setReportContent(String reportContent) {
        this.reportContent = reportContent;
    }

    public Manager(String department) {
        this.department = department;
    }

    @Override
    public void report() {
        System.out.println(department + reportContent);
    }
}
