package models;

import java.time.LocalDateTime;

public class MedicalVisit {
    private Integer id;
    private Integer userId;
    private LocalDateTime visitDate;
    private String reason;
    private String diagnosis;
    private String treatment;
    private Boolean referred;
    private String notes;

    public MedicalVisit() {}
    public Integer getId() { return id; }

    public void setId(Integer id) { this.id = id; }

    public Integer getUserId() { return userId; }

    public void setUserId(Integer userId) { this.userId = userId; }

    public LocalDateTime getVisitDate() { return visitDate; }

    public void setVisitDate(LocalDateTime visitDate) { this.visitDate = visitDate; }

    public String getReason() { return reason; }

    public void setReason(String reason) { this.reason = reason; }

    public String getDiagnosis() { return diagnosis; }

    public void setDiagnosis(String diagnosis) { this.diagnosis = diagnosis; }

    public String getTreatment() { return treatment; }

    public void setTreatment(String treatment) { this.treatment = treatment; }

    public Boolean getReferred() { return referred; }

    public void setReferred(Boolean referred) { this.referred = referred; }

    public String getNotes() { return notes; }

    public void setNotes(String notes) { this.notes = notes; }
}
