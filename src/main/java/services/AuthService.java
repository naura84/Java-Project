package services;

import dao.GenericDAO;
import models.User;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Authentication handling: login/logout and simple session tracking.
 */
public class AuthService {

    private final GenericDAO<User, Integer> userDao = new GenericDAO<>(User.class);
    // simple in-memory session map: sessionId -> userId (for demo purposes)
    private final Map<String, Integer> sessions = new ConcurrentHashMap<>();

    public User login(String email, String password) {
        String jpql = "SELECT u FROM User u WHERE u.email = :email";
        var list = userDao.findWithQuery(jpql, Map.of("email", email));
        if (list == null || list.isEmpty()) return null;
        User u = list.get(0);
        if (PasswordUtils.verifyPassword(password, u.getPassword())) {
            // create a simple session id
            String sessionId = java.util.UUID.randomUUID().toString();
            sessions.put(sessionId, u.getId());
            // attach session id on user temporarily (not persisted) — caller may want it
            u.setPassword(null); // avoid returning password
            u.setSessionId(sessionId);
            // store current session in application session holder
            AppSession.get().setCurrentUser(u);
            AppSession.get().setSessionId(sessionId);
            return u;
        }
        return null;
    }

    public void logout(String sessionId) {
        if (sessionId != null) sessions.remove(sessionId);
    }

    public boolean verifyPassword(String raw, String storedHash) {
        return PasswordUtils.verifyPassword(raw, storedHash);
    }
}
