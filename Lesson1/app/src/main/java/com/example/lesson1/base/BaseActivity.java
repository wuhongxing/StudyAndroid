package com.example.lesson1.base;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public abstract class BaseActivity<P extends BasePresenter, CONTRACT> extends AppCompatActivity implements View.OnClickListener {
    public abstract CONTRACT getContract();
    public P mPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(getContentViewID());

        initView();
        initData();
        initListener();

        mPresenter = getmPresenterInstance();
        mPresenter.bindView(this);
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        onDestory();
    }

    public abstract void initView();
    public abstract int getContentViewID();
    public abstract void initListener();
    public abstract void initData();

    public abstract P getmPresenterInstance();

    // 处理响应错误
    public abstract <ERROR> void responseError(ERROR error, Throwable throwable);

    public abstract void onDestory();
}
