package com.example.design_pattern.singleresponsibility;

public class Method {
    private void updateUserInfo(String userName, String address) {

    }

    private void updateUserInfo(String userName, String... properties) {

    }

    private void updateUserName(String userName) {

    }

    private void updateUserAddress(String userAddress) {

    }

    private void updateUserInfo(String userName, String address, boolean bool) {
        if (bool) {
            // TODO something1
        } else {
            // TODO something2
        }
    }
}
