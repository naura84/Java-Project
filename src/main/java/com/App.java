package com;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import config.EnvLoader;
import config.JPAUtil;
import config.DbInitializer;

public class App extends Application {
    
    @Override
    public void start(Stage primaryStage) throws Exception {
        try {
            // Load environment variables
            EnvLoader.load();
            
            // Initialize database schema and sample data (graceful failure if DB unavailable)
            try {
                String dbUrl = System.getProperty("DB_URL", "jdbc:mysql://localhost:3306/gestion_scolaire?serverTimezone=UTC&useSSL=false");
                String dbUser = System.getProperty("DB_USER", "root");
                String dbPassword = System.getProperty("DB_PASSWORD", "");
                DbInitializer.initializeDatabase(dbUrl, dbUser, dbPassword);
                
                // Initialize JPA
                JPAUtil.init();
                System.out.println("[App] Database initialized successfully");
            } catch (Exception dbEx) {
                System.err.println("[App] WARNING: Database initialization failed. App will run in offline mode.");
                System.err.println("[App] Error: " + dbEx.getMessage());
                // Continue anyway; UI can still load (DB calls will fail gracefully in controllers)
            }
            
            // Load login FXML
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/login.fxml"));
            loader.setControllerFactory(c -> {
                try {
                    return c.getDeclaredConstructor().newInstance();
                } catch (Exception ex) {
                    return null;
                }
            });
            Parent root = loader.load();
            
            Scene scene = new Scene(root);
            primaryStage.setTitle("Gestion Scolaire");
            primaryStage.setScene(scene);
            primaryStage.setWidth(1024);
            primaryStage.setHeight(768);
            primaryStage.show();
        } catch (Exception e) {
            System.err.println("Error in application startup:");
            e.printStackTrace();
            throw e;
        }
    }
    
    @Override
    public void stop() throws Exception {
        super.stop();
        // Close EntityManagerFactory on app exit
        JPAUtil.close();
    }
    
    public static void main(String[] args) {
        launch(args);
    }
}
