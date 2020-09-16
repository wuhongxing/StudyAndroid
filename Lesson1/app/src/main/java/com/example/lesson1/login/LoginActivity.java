package com.example.lesson1.login;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.lesson1.R;
import com.example.lesson1.base.BaseActivity;

public class LoginActivity extends BaseActivity<LoginPresenter, ILogin.VP>  {
    private EditText etName;
    private EditText etPwd;
    private Button btLogin;

    @Override
    public ILogin.VP getContract() {
        return new ILogin.VP() {
            @Override
            public void requestLogin(String name, String pwd) {
                mPresenter.getContract().requestLogin(name, pwd);
            }

            @Override
            public void resonseLoginResult(boolean loginResult) {

            }
        };
    }

    @Override
    public void initView() {
        etName = findViewById(R.id.et_name);
        etPwd = findViewById(R.id.et_pwd);
        btLogin = findViewById(R.id.bt_login);
    }

    @Override
    public int getContentViewID() {
        return R.layout.activity_main;
    }

    @Override
    public void initListener() {

    }

    @Override
    public void initData() {

    }

    @Override
    public LoginPresenter getmPresenterInstance() {
        return new LoginPresenter();
    }

    @Override
    public <ERROR> void responseError(ERROR error, Throwable throwable) {
        Toast.makeText(LoginActivity.this, throwable.getLocalizedMessage(), Toast.LENGTH_SHORT);
    }

    @Override
    public void onDestory() {

    }

    @Override
    public void onClick(View view) {
        String name = etName.getText().toString();
        String pwd = etPwd.getText().toString();

//        requestLogin(name, pwd);
        getContract().requestLogin(name, pwd);
    }

//    @Override
//    public void requestLogin(String name, String pwd) {
//        mPresenter.requestLogin(name, pwd);
//    }
//
//    @Override
//    public void resonseLoginResult(boolean loginResult) {
//        Toast.makeText(this, loginResult ? "登录成功" : "登录失败", Toast.LENGTH_SHORT);
//    }
}
