package com.example.lesson1.login;

public interface ILogin {
    public interface M {
        void requestLogin(String name, String pwd) throws Exception;
    }
    public interface VP {
        void requestLogin(String name, String pwd);
        void resonseLoginResult(boolean loginResult);
    }
}
