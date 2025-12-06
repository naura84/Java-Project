package config;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

/**
 * Small utility to load a simple `.env` file and set corresponding System properties
 * expected by `persistence.xml` placeholders.
 *
 * Usage:
 *   // very early in your application startup, before creating EntityManagerFactory
 *   config.EnvLoader.load();
 *
 * It maps the following keys from the .env file to System properties:
 *   DB_URL       -> jakarta.persistence.jdbc.url
 *   DB_USER      -> jakarta.persistence.jdbc.user
 *   DB_PASSWORD  -> jakarta.persistence.jdbc.password
 *   HIBERNATE_DIALECT -> hibernate.dialect
 *   HBM2DDL      -> hibernate.hbm2ddl.auto
 *
 * The class is intentionally minimal and has no external dependencies.
 */
public final class EnvLoader {

    private EnvLoader() {}

    public static void load() {
        Path envPath = Paths.get(System.getProperty("user.dir"), ".env");
        if (!Files.exists(envPath)) {
            // No .env present — nothing to do.
            return;
        }

        try {
            List<String> lines = Files.readAllLines(envPath, StandardCharsets.UTF_8);
            for (String raw : lines) {
                String line = raw.trim();
                if (line.isEmpty() || line.startsWith("#")) continue;
                int eq = line.indexOf('=');
                if (eq <= 0) continue;
                String key = line.substring(0, eq).trim();
                String value = line.substring(eq + 1).trim();
                // remove surrounding quotes if present
                if ((value.startsWith("\"") && value.endsWith("\"")) || (value.startsWith("'") && value.endsWith("'"))) {
                    value = value.substring(1, value.length() - 1);
                }

                switch (key) {
                    case "DB_URL":
                        System.setProperty("jakarta.persistence.jdbc.url", value);
                        break;
                    case "DB_USER":
                        System.setProperty("jakarta.persistence.jdbc.user", value);
                        break;
                    case "DB_PASSWORD":
                        System.setProperty("jakarta.persistence.jdbc.password", value);
                        break;
                    case "HIBERNATE_DIALECT":
                        System.setProperty("hibernate.dialect", value);
                        break;
                    case "HBM2DDL":
                        System.setProperty("hibernate.hbm2ddl.auto", value);
                        break;
                    case "SHOW_SQL":
                        System.setProperty("hibernate.show_sql", value);
                        break;
                    default:
                        // For any other keys, set as-is under the same name (optional)
                        System.setProperty(key, value);
                }
            }
        } catch (IOException e) {
            System.err.println("Failed to read .env file: " + e.getMessage());
        }
    }
}
