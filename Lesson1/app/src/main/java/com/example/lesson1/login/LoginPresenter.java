package com.example.lesson1.login;

import com.example.lesson1.base.BasePresenter;

public class LoginPresenter extends BasePresenter<LoginActivity, LoginModel, ILogin.VP> {
    @Override
    public LoginModel getmModelInstance() {
        return new LoginModel(this);
    }

    @Override
    public ILogin.VP getContract() {
        return new ILogin.VP() {
            @Override
            public void requestLogin(String name, String pwd) {
//                try {
//                    mModel.requestLogin(name, pwd);
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
                try {
                    mModel.getContract().requestLogin(name, pwd);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void resonseLoginResult(boolean loginResult) {
                mView.getContract().resonseLoginResult(loginResult);
//                mView.resonseLoginResult(loginResult);
            }
        };
    }
}
