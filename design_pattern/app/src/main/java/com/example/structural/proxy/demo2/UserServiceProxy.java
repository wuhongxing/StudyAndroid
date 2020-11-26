package com.example.structural.proxy.demo2;

public class UserServiceProxy implements IUserService {
    private IUserService userService;

    public void setUserService(IUserService userService) {
        this.userService = userService;
    }

    @Override
    public void add() {
        log("add");
        userService.add();
    }

    @Override
    public void delete() {
        log("delete");
        userService.delete();
    }

    @Override
    public void update() {
        log("update");
        userService.update();
    }

    @Override
    public void query() {
        log("query");
        userService.query();
    }

    private void log(String message) {
        System.out.println("日志: 使用了" + message + "方法");
    }
}
