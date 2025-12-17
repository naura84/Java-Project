package controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;
import models.User;
import services.AuthService;
import services.AppSession;

import java.net.URL;
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
        signin.setOnAction(evt -> handleLogin());
    }

    private void handleLogin() {
        String email = emailarea.getText() == null ? "" : emailarea.getText().trim();
        String password = passwordarea.getText() == null ? "" : passwordarea.getText().trim();

        if (email.isEmpty() || password.isEmpty()) {
            Alert a = new Alert(Alert.AlertType.WARNING, "Please enter email and password.");
            a.showAndWait();
            return;
        }

        try {
            AuthService auth = new AuthService();
            User u = auth.login(email, password);
            if (u == null) {
                Alert a = new Alert(Alert.AlertType.ERROR, "Invalid credentials.");
                a.showAndWait();
                return;
            }

            // Load appropriate dashboard based on role
            Stage stage = (Stage) signin.getScene().getWindow();
            String fxml = "/com/dash.fxml";
            if (u.getRole() != null && u.getRole().getCode() != null) {
                switch (u.getRole().getCode()) {
                    case STUDENT:
                        fxml = "/com/dashEleve.fxml";
                        break;
                    case TEACHER:
                        fxml = "/com/dashProf.fxml";
                        break;
                    default:
                        fxml = "/com/dash.fxml";
                }
            }

            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxml));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            stage.setScene(scene);

        } catch (Exception ex) {
            ex.printStackTrace();
            Alert a = new Alert(Alert.AlertType.ERROR, "Login failed: " + ex.getMessage());
            a.showAndWait();
        }
    }
}
