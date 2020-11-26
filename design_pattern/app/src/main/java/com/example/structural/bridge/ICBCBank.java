package com.example.structural.bridge;

public class ICBCBank extends Bank {

    public ICBCBank(Account account) {
        super(account);
    }

    @Override
    protected Account openAccount() {
        System.out.println("打开工商银行账号");
        account.openAccount();
        return account;
    }
}
