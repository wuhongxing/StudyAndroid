package com.example.design_pattern.openclose;

public class JavaDiscountCourse extends JavaCourse {

    public JavaDiscountCourse(Integer mID, String mName, Double mPrice) {
        super(mID, mName, mPrice);
    }

    public Double getOriginPrice() {
        return super.getPrice();
    }

    @Override
    public Double getPrice() {
        return super.getPrice() * 0.8;
    }
}
