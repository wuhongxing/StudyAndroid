package com.example.creational.prototype;

import java.text.MessageFormat;

public class MailUtil {
    public static void sendMail(Mail mail) {
        System.out.println( mail.getName() + mail.getEmailAddress());
    }

    public static void saveOriginMailRecord(Mail mail) {
        System.out.println("originMail" + mail.getContent());
    }
}
