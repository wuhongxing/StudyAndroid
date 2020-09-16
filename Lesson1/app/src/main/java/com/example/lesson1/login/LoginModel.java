package com.example.lesson1.login;

import com.example.lesson1.base.BaseModel;

public class LoginModel extends BaseModel<LoginPresenter, ILogin.M> {
    public LoginModel(LoginPresenter mPresener) {
        super(mPresener);
    }

    @Override
    public ILogin.M getContract() {
        return new ILogin.M() {
            @Override
            public void requestLogin(String name, String pwd) throws Exception {
                if ("abc".equals(name) && "123".equals(pwd)) {
                    mPresener.getContract().resonseLoginResult(true);
                } else {
                    mPresener.getContract().resonseLoginResult(false);
                }
            }
        };
    }
}
