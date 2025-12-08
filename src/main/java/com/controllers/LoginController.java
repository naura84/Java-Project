package com.controllers;

import dao.GenericDAO;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import models.User;
import models.RoleType;
import services.AuthService;
import services.AppSession;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class LoginController implements Initializable {

    @FXML
    private TextArea emailarea;

    @FXML
    private TextArea passwordarea;

    @FXML
    private Button signin;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // Prefer FXML onAction (#onSignIn). Keep initialize minimal.
    }

    private void attemptLogin() {
        try {
            String email = emailarea != null ? emailarea.getText().trim() : "";
            String password = passwordarea != null ? passwordarea.getText().trim() : "";
            AuthService auth = new AuthService();
            User u = auth.login(email, password);
            if (u != null) {
                // store session (AuthService also sets AppSession)
                AppSession.get().setCurrentUser(u);
                showAlert(Alert.AlertType.INFORMATION, "Connexion réussie", "Bonjour, " + (u.getUsername() != null ? u.getUsername() : u.getEmail()));
                // decide target dashboard by role enum if present, otherwise fallback to label
                String target = "/com/dashboard.fxml"; // default admin
                if (u.getRole() != null) {
                    RoleType rt = u.getRole().getCode();
                    if (rt != null) {
                        switch (rt) {
                            case STUDENT -> target = "/com/dashboardEleve.fxml";
                            case TEACHER -> target = "/com/dashboardProf.fxml";
                            default -> target = "/com/dashboard.fxml";
                        }
                    } else if (u.getRole().getLabel() != null) {
                        String roleLabel = u.getRole().getLabel().toLowerCase();
                        if (roleLabel.contains("student") || roleLabel.contains("eleve") || roleLabel.contains("etudiant")) {
                            target = "/com/dashboardEleve.fxml";
                        } else if (roleLabel.contains("prof") || roleLabel.contains("enseignant") || roleLabel.contains("teacher")) {
                            target = "/com/dashboardProf.fxml";
                        }
                    }
                }
                try {
                    FXMLLoader loader = new FXMLLoader(getClass().getResource(target));
                    Parent root = loader.load();
                    Scene scene = signin.getScene();
                    if (scene != null) {
                        scene.setRoot(root);
                    } else {
                        Stage st = (Stage) signin.getScene().getWindow();
                        st.setScene(new Scene(root));
                        st.show();
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                    showAlert(Alert.AlertType.ERROR, "Navigation Error", "Impossible d'ouvrir le tableau de bord.");
                }
            } else {
                showAlert(Alert.AlertType.ERROR, "Échec de la connexion", "Email ou mot de passe incorrect.");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @FXML
    public void onSignIn() {
        attemptLogin();
    }

    private void showAlert(Alert.AlertType type, String title, String message) {
        Alert a = new Alert(type);
        a.setTitle(title);
        a.setHeaderText(null);
        a.setContentText(message);
        a.showAndWait();
    }
}
