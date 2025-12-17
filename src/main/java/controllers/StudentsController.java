package controllers;

import dao.GenericDAO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.control.cell.PropertyValueFactory;
import models.Etudiant;
import models.User;

import java.net.URL;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;

public class StudentsController implements Initializable {

    @FXML private TableView<Etudiant> studentsTable;
    @FXML private TableColumn<Etudiant, Integer> colId;
    @FXML private TableColumn<Etudiant, String> colStudentNumber;
    @FXML private TableColumn<Etudiant, String> colName;
    @FXML private TableColumn<Etudiant, String> colEmail;
    @FXML private TableColumn<Etudiant, String> colProgram;
    @FXML private TableColumn<Etudiant, String> colLevel;
    @FXML private TableColumn<Etudiant, String> colStatus;
    @FXML private TableColumn<Etudiant, Void> colActions;
    @FXML private TextField searchField;
    @FXML private Button addBtn;

    private final GenericDAO<Etudiant, Integer> dao = new GenericDAO<>(Etudiant.class);

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        setupColumns();
        loadStudents();

        if (searchField != null) {
            searchField.textProperty().addListener((obs, oldV, newV) -> filter(newV));
        }

        if (addBtn != null) {
            addBtn.setOnAction(e -> {
                // Placeholder: open modal to add student (not implemented)
                Alert a = new Alert(Alert.AlertType.INFORMATION, "Add student form not implemented.");
                a.showAndWait();
            });
        }
    }

    private void setupColumns() {
        if (colId != null) colId.setCellValueFactory(new PropertyValueFactory<>("id"));
        if (colStudentNumber != null) colStudentNumber.setCellValueFactory(new PropertyValueFactory<>("studentNumber"));

        if (colName != null) colName.setCellValueFactory(c -> {
            Etudiant s = c.getValue();
            User u = s.getUser();
            String name = "";
            if (u != null && u.getProfile() != null) {
                name = Optional.ofNullable(u.getProfile().getPreferredName()).orElse(Optional.ofNullable(u.getProfile().getFirstName()).orElse(""));
            }
            return new javafx.beans.property.SimpleStringProperty(name);
        });

        if (colEmail != null) colEmail.setCellValueFactory(c -> {
            Etudiant s = c.getValue();
            User u = s.getUser();
            String e = (u != null && u.getEmail() != null) ? u.getEmail() : "";
            return new javafx.beans.property.SimpleStringProperty(e);
        });

        if (colProgram != null) colProgram.setCellValueFactory(c -> {
            String p = c.getValue().getProgram() != null ? c.getValue().getProgram().getName() : "";
            return new javafx.beans.property.SimpleStringProperty(p);
        });

        if (colLevel != null) colLevel.setCellValueFactory(c -> new javafx.beans.property.SimpleStringProperty(Optional.ofNullable(c.getValue().getCurrentLevel()).orElse("")));
        if (colStatus != null) colStatus.setCellValueFactory(c -> new javafx.beans.property.SimpleStringProperty(Optional.ofNullable(c.getValue().getStatus()).orElse("")));

        if (colActions != null) {
            colActions.setCellFactory(tc -> new TableCell<>() {
                private final Button edit = new Button("Edit");
                private final Button del = new Button("Delete");
                private final HBox box = new HBox(6, edit, del);

                {
                    edit.setOnAction(e -> {
                        Etudiant s = getTableRow().getItem();
                        if (s != null) {
                            Alert a = new Alert(Alert.AlertType.INFORMATION, "Edit not implemented for student id=" + s.getId());
                            a.showAndWait();
                        }
                    });
                    del.setOnAction(e -> {
                        Etudiant s = getTableRow().getItem();
                        if (s != null) {
                            Alert confirm = new Alert(Alert.AlertType.CONFIRMATION, "Delete student " + s.getStudentNumber() + "?", ButtonType.YES, ButtonType.NO);
                            Optional<ButtonType> res = confirm.showAndWait();
                            if (res.isPresent() && res.get() == ButtonType.YES) {
                                try {
                                    dao.delete(s);
                                    loadStudents();
                                } catch (Exception ex) {
                                    ex.printStackTrace();
                                    new Alert(Alert.AlertType.ERROR, "Failed to delete: " + ex.getMessage()).showAndWait();
                                }
                            }
                        }
                    });
                }

                @Override
                protected void updateItem(Void item, boolean empty) {
                    super.updateItem(item, empty);
                    if (empty) setGraphic(null); else setGraphic(box);
                }
            });
        }
    }

    private void loadStudents() {
        try {
            List<Etudiant> list = dao.findAll();
            ObservableList<Etudiant> obs = FXCollections.observableArrayList(list);
            if (studentsTable != null) studentsTable.setItems(obs);
        } catch (Exception ex) {
            ex.printStackTrace();
            new Alert(Alert.AlertType.ERROR, "Failed to load students: " + ex.getMessage()).showAndWait();
        }
    }

    private void filter(String q) {
        if (q == null || q.isBlank()) { loadStudents(); return; }
        String qq = q.toLowerCase();
        ObservableList<Etudiant> all = studentsTable.getItems();
        if (all == null) return;
        ObservableList<Etudiant> filtered = all.filtered(s -> {
            String name = "";
            User u = s.getUser();
            if (u != null && u.getProfile() != null) name = Optional.ofNullable(u.getProfile().getPreferredName()).orElse(Optional.ofNullable(u.getProfile().getFirstName()).orElse(""));
            String email = u != null && u.getEmail() != null ? u.getEmail() : "";
            return name.toLowerCase().contains(qq) || email.toLowerCase().contains(qq) || Optional.ofNullable(s.getStudentNumber()).orElse("").toLowerCase().contains(qq);
        });
        studentsTable.setItems(filtered);
    }
}
