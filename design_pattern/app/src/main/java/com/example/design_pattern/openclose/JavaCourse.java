package com.example.design_pattern.openclose;

public class JavaCourse implements ICourse {
    private Integer mID;
    private String mName;
    private Double mPrice;

    public JavaCourse(Integer mID, String mName, Double mPrice) {
        this.mID = mID;
        this.mName = mName;
        this.mPrice = mPrice;
    }

    @Override
    public Integer getId() {
        return mID;
    }

    @Override
    public String getName() {
        return mName;
    }

    @Override
    public Double getPrice() {
        return mPrice;
    }
}
