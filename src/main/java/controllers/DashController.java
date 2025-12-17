package controllers;

import dao.GenericDAO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import models.Enseignant;
import models.Etudiant;
import models.StaffNonTeaching;
import models.User;
import services.AppSession;
import services.AuthService;

import java.net.URL;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.ResourceBundle;

public class DashController implements Initializable {

    @FXML
    private Label welcomeLabel;

    @FXML
    private Label roleLabel;

    @FXML
    private Label displayNameLabel;

    @FXML
    private Label totalStudentsLabel;

    @FXML
    private Label totalTeachersLabel;

    @FXML
    private Label totalStaffLabel;

    @FXML
    private PieChart statistiques_camembert;

    @FXML
    private BarChart statistiques_baton;

    @FXML
    private Button log_out;

    @FXML
    private Button profil;
    @FXML
    private Button student;

    // Calendar UI elements
    @FXML
    private Button prevMonthBtn;
    @FXML
    private Button nextMonthBtn;
    @FXML
    private Label monthLabel;
    @FXML
    private GridPane calendarGrid;

    private java.time.YearMonth currentYearMonth = java.time.YearMonth.now();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            populateUserInfo();
            populateCountsAndCharts();
            initCalendarControls();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        if (log_out != null) {
            log_out.setOnAction(evt -> handleLogout());
        }
        if (student != null) {
            student.setOnAction(evt -> {
                try {
                    Stage stage = (Stage) log_out.getScene().getWindow();
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/students.fxml"));
                    Parent root = loader.load();
                    Scene scene = new Scene(root);
                    stage.setScene(scene);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            });
        }
    }

    private void populateUserInfo() {
        User u = AppSession.get().getCurrentUser();
        String name = "Guest";
        String role = "";
        if (u != null) {
            if (u.getProfile() != null && u.getProfile().getPreferredName() != null && !u.getProfile().getPreferredName().isEmpty()) {
                name = u.getProfile().getPreferredName();
            } else if (u.getProfile() != null && u.getProfile().getFirstName() != null) {
                name = u.getProfile().getFirstName();
            } else if (u.getUsername() != null) {
                name = u.getUsername();
            }
            if (u.getRole() != null) role = u.getRole().getLabel();
        }

        if (welcomeLabel != null) welcomeLabel.setText("Hi, " + name);
        if (displayNameLabel != null) displayNameLabel.setText(name);
        if (roleLabel != null) roleLabel.setText(role == null ? "" : role);
    }

    private void populateCountsAndCharts() {
        NumberFormat nf = NumberFormat.getInstance(Locale.getDefault());
        try {
            long students = new GenericDAO<>(Etudiant.class).count();
            long teachers = new GenericDAO<>(Enseignant.class).count();
            long staff = new GenericDAO<>(StaffNonTeaching.class).count();

            if (totalStudentsLabel != null) totalStudentsLabel.setText(nf.format(students));
            if (totalTeachersLabel != null) totalTeachersLabel.setText(nf.format(teachers));
            if (totalStaffLabel != null) totalStaffLabel.setText(nf.format(staff));

            if (statistiques_camembert != null) {
                ObservableList<PieChart.Data> pieData = FXCollections.observableArrayList(
                        new PieChart.Data("Students", Math.max(0, students)),
                        new PieChart.Data("Teachers", Math.max(0, teachers)),
                        new PieChart.Data("Staff", Math.max(0, staff))
                );
                statistiques_camembert.setData(pieData);
            }

            if (statistiques_baton != null) {
                statistiques_baton.getData().clear();
                XYChart.Series<String, Number> series = new XYChart.Series<>();
                series.setName("Counts");
                series.getData().add(new XYChart.Data<>("Students", students));
                series.getData().add(new XYChart.Data<>("Teachers", teachers));
                series.getData().add(new XYChart.Data<>("Staff", staff));
                statistiques_baton.getData().add(series);
            }
        } catch (Exception ex) {
            // If DB not available, leave defaults and log error
            ex.printStackTrace();
        }
    }

    private void initCalendarControls() {
        if (monthLabel != null) monthLabel.setText(currentYearMonth.getMonth()
            .getDisplayName(java.time.format.TextStyle.FULL, Locale.getDefault()) + " " + currentYearMonth.getYear());

        if (prevMonthBtn != null) prevMonthBtn.setOnAction(e -> {
            currentYearMonth = currentYearMonth.minusMonths(1);
            renderCalendar();
        });
        if (nextMonthBtn != null) nextMonthBtn.setOnAction(e -> {
            currentYearMonth = currentYearMonth.plusMonths(1);
            renderCalendar();
        });

        renderCalendar();
    }

    private void renderCalendar() {
        if (calendarGrid == null) return;
        calendarGrid.getChildren().clear();
        java.time.DayOfWeek[] daysOfWeek = java.time.DayOfWeek.values();
        // header: Monday..Sunday
        for (int i = 0; i < 7; i++) {
            Label d = new Label(daysOfWeek[i].getDisplayName(java.time.format.TextStyle.SHORT_STANDALONE, Locale.getDefault()));
            d.setStyle("-fx-font-weight:bold;-fx-text-fill:#444;");
            GridPane.setRowIndex(d, 0);
            GridPane.setColumnIndex(d, i);
            calendarGrid.getChildren().add(d);
        }

        java.time.LocalDate firstOfMonth = currentYearMonth.atDay(1);
        // compute column where the 1st of month appears (Monday=0 .. Sunday=6)
        int firstColumn = (firstOfMonth.getDayOfWeek().getValue() + 6) % 7;
        int daysInMonth = currentYearMonth.lengthOfMonth();

        int row = 1;
        int col = firstColumn;
        for (int day = 1; day <= daysInMonth; day++) {
            java.time.LocalDate date = currentYearMonth.atDay(day);
            Label dayLabel = new Label(String.valueOf(day));
            dayLabel.setPrefWidth(40);
            dayLabel.setPrefHeight(32);
            dayLabel.setStyle("-fx-alignment:center; -fx-background-color:transparent; -fx-border-radius:6; -fx-background-radius:6;");

            // highlight today
            if (date.equals(java.time.LocalDate.now())) {
                dayLabel.setStyle(dayLabel.getStyle() + " -fx-background-color:#0b1957; -fx-text-fill:white; -fx-font-weight:bold;");
            }

            GridPane.setRowIndex(dayLabel, row);
            GridPane.setColumnIndex(dayLabel, col);
            calendarGrid.getChildren().add(dayLabel);

            col++;
            if (col > 6) { col = 0; row++; }
        }

        if (monthLabel != null) monthLabel.setText(currentYearMonth.getMonth().name().substring(0,1)
                + currentYearMonth.getMonth().name().substring(1).toLowerCase() + " " + currentYearMonth.getYear());
    }

    private void handleLogout() {
        try {
            String sessionId = AppSession.get().getSessionId();
            new AuthService().logout(sessionId);
        } catch (Exception ignore) {}

        AppSession.get().setCurrentUser(null);
        AppSession.get().setSessionId(null);

        try {
            Stage stage = (Stage) (log_out != null ? log_out.getScene().getWindow() : profil.getScene().getWindow());
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/login.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            stage.setScene(scene);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
