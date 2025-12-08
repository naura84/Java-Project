package com.controllers;

import dao.GenericDAO;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import models.Course;
import models.Enseignant;
import services.BaseService;

import java.net.URL;
import java.util.ResourceBundle;

public class DashboardProfController implements Initializable {

    @FXML
    private TextField search;

    @FXML
    private Pane total_courses;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            BaseService<Course, Integer> courseService = new BaseService<>(new GenericDAO<>(Course.class));
            BaseService<Enseignant, Integer> enseService = new BaseService<>(new GenericDAO<>(Enseignant.class));

            long courses = courseService.count();
            long teachers = enseService.count();
            System.out.println("Courses: " + courses + ", Teachers: " + teachers);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
