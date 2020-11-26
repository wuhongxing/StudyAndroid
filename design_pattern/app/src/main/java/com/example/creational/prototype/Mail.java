package com.example.creational.prototype;

import androidx.annotation.NonNull;

public class Mail implements Cloneable {
    private String name;
    private String emailAddress;
    private String content;

    public Mail() {
        System.out.println("name" + name + "emailAddress" + emailAddress + "content" + content);
    }

    public Mail(String name, String emailAddress, String content) {
        this.name = name;
        this.emailAddress = emailAddress;
        this.content = content;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getName() {
        return name;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public String getContent() {
        return content;
    }

    @NonNull
    @Override
    protected Object clone() throws CloneNotSupportedException {
        System.out.println("clone mail object");
        return super.clone();
    }
}
