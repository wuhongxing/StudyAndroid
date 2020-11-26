package com.example.behavioral.observer;

public class Question {
    private String userName;
    private String questioinContent;

    public Question(String userName, String questioinContent) {
        this.userName = userName;
        this.questioinContent = questioinContent;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getQuestioinContent() {
        return questioinContent;
    }

    public void setQuestioinContent(String questioinContent) {
        this.questioinContent = questioinContent;
    }
}
