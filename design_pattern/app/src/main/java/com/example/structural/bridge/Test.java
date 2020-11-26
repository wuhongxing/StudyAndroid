package com.example.structural.bridge;

public class Test {
    public static void main(String[] args) {
        ABCBank abcBank = new ABCBank(new DepositAccount());
        Account abcAccount = abcBank.openAccount();
        abcAccount.showAccountType();
    }
}
