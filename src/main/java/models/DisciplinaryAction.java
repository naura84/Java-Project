package models;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class DisciplinaryAction {
    private Integer id;
    private Integer studentId;
    private Integer reportedBy;
    private LocalDate incidentDate;
    private String category;
    private String description;
    private String actionTaken;
    private String status;
    private LocalDateTime createdAt;

    public DisciplinaryAction() {}
    public Integer getId() { return id; }

    public void setId(Integer id) { this.id = id; }

    public Integer getStudentId() { return studentId; }

    public void setStudentId(Integer studentId) { this.studentId = studentId; }

    public Integer getReportedBy() { return reportedBy; }

    public void setReportedBy(Integer reportedBy) { this.reportedBy = reportedBy; }

    public LocalDate getIncidentDate() { return incidentDate; }

    public void setIncidentDate(LocalDate incidentDate) { this.incidentDate = incidentDate; }

    public String getCategory() { return category; }

    public void setCategory(String category) { this.category = category; }

    public String getDescription() { return description; }

    public void setDescription(String description) { this.description = description; }

    public String getActionTaken() { return actionTaken; }

    public void setActionTaken(String actionTaken) { this.actionTaken = actionTaken; }

    public String getStatus() { return status; }

    public void setStatus(String status) { this.status = status; }

    public LocalDateTime getCreatedAt() { return createdAt; }

    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
}
