package services;

import models.User;

/**
 * Simple notification delivery service. In this project we keep implementations as
 * placeholders that log actions. Integrate with email/SMS providers later.
 */
public class NotificationService {

    public void sendEmail(String to, String subject, String body) {
        System.out.println("[EMAIL] to=" + to + " subject=" + subject + " body=" + body);
    }

    public void sendSms(String phone, String message) {
        System.out.println("[SMS] to=" + phone + " msg=" + message);
    }

    public void sendInternal(User user, String message) {
        System.out.println("[INTERNAL] user=" + (user != null ? user.getEmail() : "?") + " msg=" + message);
    }
}
