package models;

import java.time.LocalDate;

public class Etudiant {
    private Integer id;
    private String studentNumber;
    private LocalDate admissionDate;
    private Integer programId;
    private String currentLevel;
    private Integer yearAdmitted;
    private String status;
    private Integer scholarshipId;
    private String accommodationDetails;
    private java.time.LocalDateTime createdAt;

    public Etudiant() {}
    public Integer getId() { return id; }

    public void setId(Integer id) { this.id = id; }

    public String getStudentNumber() { return studentNumber; }

    public void setStudentNumber(String studentNumber) { this.studentNumber = studentNumber; }

    public LocalDate getAdmissionDate() { return admissionDate; }

    public void setAdmissionDate(LocalDate admissionDate) { this.admissionDate = admissionDate; }

    public Integer getProgramId() { return programId; }

    public void setProgramId(Integer programId) { this.programId = programId; }

    public String getCurrentLevel() { return currentLevel; }

    public void setCurrentLevel(String currentLevel) { this.currentLevel = currentLevel; }

    public Integer getYearAdmitted() { return yearAdmitted; }

    public void setYearAdmitted(Integer yearAdmitted) { this.yearAdmitted = yearAdmitted; }

    public String getStatus() { return status; }

    public void setStatus(String status) { this.status = status; }

    public Integer getScholarshipId() { return scholarshipId; }

    public void setScholarshipId(Integer scholarshipId) { this.scholarshipId = scholarshipId; }

    public String getAccommodationDetails() { return accommodationDetails; }

    public void setAccommodationDetails(String accommodationDetails) { this.accommodationDetails = accommodationDetails; }

    public java.time.LocalDateTime getCreatedAt() { return createdAt; }

    public void setCreatedAt(java.time.LocalDateTime createdAt) { this.createdAt = createdAt; }

    @Override
    public String toString() { return "Etudiant{"+"id="+id+", studentNumber='"+studentNumber+'\''+"}"; }
}
