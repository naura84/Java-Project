package services;

import dao.GenericDAO;
import models.Role;
import models.User;
import models.UserProfile;

/**
 * User management service: create users, assign role, manage profiles.
 */
public class UserService extends BaseService<User, Integer> {

    private final GenericDAO<Role, Integer> roleDao = new GenericDAO<>(Role.class);

    public UserService(GenericDAO<User, Integer> dao) {
        super(dao);
    }

    public User createUser(User user, String rawPassword) {
        if (user == null) throw new IllegalArgumentException("user");
        user.setPassword(PasswordUtils.hashPassword(rawPassword));
        return save(user);
    }

    public User assignRole(User user, Role role) {
        user.setRole(role);
        return update(user);
    }

    public User assignRoleByName(User user, String roleName) {
        String jpql = "SELECT r FROM Role r WHERE r.name = :name";
        java.util.List<Role> list = roleDao.findWithQuery(jpql, java.util.Map.of("name", roleName));
        if (list.isEmpty()) return user;
        return assignRole(user, list.get(0));
    }

    public User addProfile(User user, UserProfile profile) {
        // this is a simple association: set owner and save profile via cascade or separate DAO
        profile.setUser(user);
        // if UserProfile is persisted via cascade, update user; else persist profile via DAO
        return update(user);
    }
}
