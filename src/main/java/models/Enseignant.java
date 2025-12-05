package models;

import java.time.LocalDate;

public class Enseignant {
    private Integer id;
    private String employeeNumber;
    private Integer departmentId;
    private LocalDate hireDate;
    private String jobTitle;
    private String specialization;
    private String workEmail;
    private String workPhone;
    private String status;
    private java.time.LocalDateTime createdAt;

    public Enseignant() {}
    public Integer getId() { return id; }

    public void setId(Integer id) { this.id = id; }

    public String getEmployeeNumber() { return employeeNumber; }

    public void setEmployeeNumber(String employeeNumber) { this.employeeNumber = employeeNumber; }

    public Integer getDepartmentId() { return departmentId; }

    public void setDepartmentId(Integer departmentId) { this.departmentId = departmentId; }

    public LocalDate getHireDate() { return hireDate; }

    public void setHireDate(LocalDate hireDate) { this.hireDate = hireDate; }

    public String getJobTitle() { return jobTitle; }

    public void setJobTitle(String jobTitle) { this.jobTitle = jobTitle; }

    public String getSpecialization() { return specialization; }

    public void setSpecialization(String specialization) { this.specialization = specialization; }

    public String getWorkEmail() { return workEmail; }

    public void setWorkEmail(String workEmail) { this.workEmail = workEmail; }

    public String getWorkPhone() { return workPhone; }

    public void setWorkPhone(String workPhone) { this.workPhone = workPhone; }

    public String getStatus() { return status; }

    public void setStatus(String status) { this.status = status; }

    public java.time.LocalDateTime getCreatedAt() { return createdAt; }

    public void setCreatedAt(java.time.LocalDateTime createdAt) { this.createdAt = createdAt; }

    @Override
    public String toString() { return "Enseignant{"+"id="+id+", emp='"+employeeNumber+'\''+"}"; }
}
