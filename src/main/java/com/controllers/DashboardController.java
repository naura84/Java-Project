package com.controllers;

import dao.GenericDAO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import models.Enseignant;
import models.Etudiant;
import models.StaffNonTeaching;
import services.BaseService;

import java.net.URL;
import java.util.ResourceBundle;


public class DashboardController implements Initializable {

    @FXML
    private TextField search;

    @FXML
    private Pane total_student;

    @FXML
    private Pane total_teacher;

    @FXML
    private Pane total_staff;

    @FXML
    private Label totalStudentLabel;

    @FXML
    private Label totalTeacherLabel;

    @FXML
    private Label totalStaffLabel;

    @FXML
    private PieChart statistiques_camembert;

    @FXML
    private BarChart<String, Number> statistiques_baton;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            BaseService<Etudiant, Integer> etuService = new BaseService<>(new GenericDAO<>(Etudiant.class));
            BaseService<Enseignant, Integer> enseService = new BaseService<>(new GenericDAO<>(Enseignant.class));
            BaseService<StaffNonTeaching, Integer> staffService = new BaseService<>(new GenericDAO<>(StaffNonTeaching.class));

            long students = etuService.count();
            long teachers = enseService.count();
            long staffs = staffService.count();

            if (totalStudentLabel != null) totalStudentLabel.setText(String.valueOf(students));
            if (totalTeacherLabel != null) totalTeacherLabel.setText(String.valueOf(teachers));
            if (totalStaffLabel != null) totalStaffLabel.setText(String.valueOf(staffs));

            if (statistiques_camembert != null) {
                ObservableList<PieChart.Data> pieData = FXCollections.observableArrayList(
                        new PieChart.Data("Students", students),
                        new PieChart.Data("Teachers", teachers),
                        new PieChart.Data("Staffs", staffs)
                );
                statistiques_camembert.setData(pieData);
            }

            if (statistiques_baton != null) {
                XYChart.Series<String, Number> series = new XYChart.Series<>();
                series.setName("Counts");
                series.getData().add(new XYChart.Data<>("Students", students));
                series.getData().add(new XYChart.Data<>("Teachers", teachers));
                series.getData().add(new XYChart.Data<>("Staffs", staffs));
                statistiques_baton.getData().clear();
                statistiques_baton.getData().add(series);
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
