package com.example.structural.proxy.demo2;

public class UserServiceImpl implements IUserService {
    @Override
    public void add() {
        // 最好不要改以前的代码手动加
        //System.out.println("日志：add 方法执行了");
        System.out.println("增加一个用户");
    }

    @Override
    public void delete() {
        System.out.println("删除一个用户");
    }

    @Override
    public void update() {
        System.out.println("更新一个用户");
    }

    @Override
    public void query() {
        System.out.println("查询一个用户");
    }
}
