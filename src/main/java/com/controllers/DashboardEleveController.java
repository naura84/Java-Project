package com.controllers;

import dao.GenericDAO;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import models.Course;
import models.Etudiant;
import services.BaseService;

import java.net.URL;
import java.util.ResourceBundle;

public class DashboardEleveController implements Initializable {

    @FXML
    private TextField search;

    @FXML
    private Pane total_courses;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            BaseService<Course, Integer> courseService = new BaseService<>(new GenericDAO<>(Course.class));
            BaseService<Etudiant, Integer> etuService = new BaseService<>(new GenericDAO<>(Etudiant.class));

            long courses = courseService.count();
            long students = etuService.count();

            // For now, we log counts. If you want labels bound, add fx:id and set text here.
            System.out.println("Courses: " + courses + ", Students: " + students);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
