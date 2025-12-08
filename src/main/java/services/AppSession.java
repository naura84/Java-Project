package services;

import models.User;

/**
 * Simple in-memory application session holder (singleton) for the running JavaFX app.
 */
public class AppSession {

    private static final AppSession INSTANCE = new AppSession();

    private User currentUser;
    private String sessionId;

    private AppSession() {
    }

    public static AppSession get() {
        return INSTANCE;
    }

    public User getCurrentUser() {
        return currentUser;
    }

    public void setCurrentUser(User currentUser) {
        this.currentUser = currentUser;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }
}
