package com.example.creational.prototype;

public class Test {
    public static void main(String[] args) throws CloneNotSupportedException {
        Mail mail = new Mail();
        mail.setContent("初始化模板");
        for (int i = 0; i < 10; i++) {
            Mail tempMail = (Mail)mail.clone();
            tempMail.setName("姓名" + i);
            tempMail.setEmailAddress("email" + i);
            tempMail.setContent("content" + i);
            MailUtil.sendMail(tempMail);
        }
        MailUtil.saveOriginMailRecord(mail);
    }
}
