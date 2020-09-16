package com.example.lesson1.base;

public abstract class BaseModel<P extends BasePresenter, CONTRACT> extends SuperBase<CONTRACT> {
    public P mPresener;

    public BaseModel(P mPresener) {
        this.mPresener = mPresener;
    }
}
