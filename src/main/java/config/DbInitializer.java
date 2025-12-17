package config;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Database initializer - creates database and imports schema/data
 */
public class DbInitializer {

    public static void initializeDatabase(String dbUrl, String dbUser, String dbPassword) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            // Extract host/port from dbUrl (format: jdbc:mysql://host:port/dbname)
            String[] urlParts = dbUrl.split("/");
            String hostPort = urlParts[2]; // e.g., "localhost:3306"
            String dbName = urlParts[3];   // e.g., "gestion_scolaire"
            
            // Step 1: Create database
            String rootUrl = "jdbc:mysql://" + hostPort + "/?useSSL=false&serverTimezone=UTC";
            try (Connection conn = DriverManager.getConnection(rootUrl, dbUser, dbPassword);
                 Statement stmt = conn.createStatement()) {
                String createDbSql = "CREATE DATABASE IF NOT EXISTS " + dbName + 
                                    " CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci";
                stmt.executeUpdate(createDbSql);
                System.out.println("[DbInitializer] Database '" + dbName + "' ready.");
            }
            
            // Step 2: Import schema and sample data
            try (Connection conn = DriverManager.getConnection(dbUrl, dbUser, dbPassword)) {
                executeSqlScript(conn, "data/database.sql");
                executeSqlScript(conn, "data/sample_data.sql");
                System.out.println("[DbInitializer] ✓ Database initialized successfully");
            }
        } catch (Exception e) {
            System.err.println("[DbInitializer] ✗ Error: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private static void executeSqlScript(Connection conn, String filePath) throws SQLException, IOException {
        File file = new File(filePath);
        if (!file.exists()) {
            System.err.println("[DbInitializer] File not found: " + filePath);
            return;
        }
        
        StringBuilder sql = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                line = line.trim();
                if (!line.isEmpty() && !line.startsWith("--") && !line.startsWith("/*")) {
                    sql.append(line).append(" ");
                    if (line.endsWith(";")) {
                        String query = sql.toString().trim();
                        query = query.substring(0, query.length() - 1); // Remove trailing ;
                        
                        try (Statement stmt = conn.createStatement()) {
                            stmt.execute(query);
                        } catch (SQLException e) {
                            // Ignore harmless errors (table exists, duplicate entries, etc.)
                            if (!isSafeToIgnore(e)) {
                                System.err.println("[DbInitializer] SQL Error: " + e.getMessage());
                            }
                        }
                        sql = new StringBuilder();
                    }
                }
            }
        }
    }

    private static boolean isSafeToIgnore(SQLException e) {
        String msg = e.getMessage().toLowerCase();
        return msg.contains("already exists") 
            || msg.contains("duplicate entry") 
            || msg.contains("duplicate key");
    }
}
