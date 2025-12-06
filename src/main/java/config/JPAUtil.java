package config;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

/**
 * Simple JPA utility to provide an `EntityManagerFactory` and `EntityManager`.
 *
 * Usage:
 *  - Call `EnvLoader.load()` early (to set JDBC system properties) before first use.
 *  - Call `JPAUtil.init()` once (optional: it will lazy-init on first `getEntityManager()`).
 *  - Call `JPAUtil.getEntityManager()` when you need an `EntityManager` and close it after use.
 */
public final class JPAUtil {

    private static final String DEFAULT_PU = "gestion-scolaire";
    private static EntityManagerFactory emf;

    private JPAUtil() {}

    public static synchronized void init() {
        if (emf == null) {
            emf = Persistence.createEntityManagerFactory(DEFAULT_PU);
        }
    }

    public static synchronized void init(String persistenceUnitName) {
        if (emf == null) {
            emf = Persistence.createEntityManagerFactory(persistenceUnitName);
        }
    }

    public static EntityManager getEntityManager() {
        if (emf == null) init();
        return emf.createEntityManager();
    }

    public static synchronized void close() {
        if (emf != null && emf.isOpen()) {
            emf.close();
            emf = null;
        }
    }
}
