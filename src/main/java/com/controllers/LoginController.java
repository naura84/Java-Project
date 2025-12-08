package com.controllers;

import dao.GenericDAO;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import models.User;
import services.BaseService;

import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
        if (signin != null) {
            signin.setOnAction(ev -> attemptLogin());
        }
    }

    private void attemptLogin() {
        try {
            String email = emailarea != null ? emailarea.getText().trim() : "";
            String password = passwordarea != null ? passwordarea.getText().trim() : "";

            GenericDAO<User, Integer> userDao = new GenericDAO<>(User.class);
            String jpql = "SELECT u FROM User u WHERE u.email = :email AND u.password = :password";
            Map<String, Object> params = new HashMap<>();
            params.put("email", email);
            params.put("password", password);
            List<User> result = userDao.findWithQuery(jpql, params);

            if (result != null && !result.isEmpty()) {
                User u = result.get(0);
                System.out.println("Login success: " + u.getUsername() + " (" + u.getEmail() + ")");
            } else {
                System.out.println("Login failed for " + email);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
