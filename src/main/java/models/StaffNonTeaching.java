package models;

import java.time.LocalDate;

public class StaffNonTeaching {
    private Integer id;
    private String employeeNumber;
    private Integer departmentId;
    private LocalDate hireDate;
    private String roleTitle;
    private String workEmail;
    private String workPhone;
    private String status;

    public StaffNonTeaching() {}
    public Integer getId() { return id; }

    public void setId(Integer id) { this.id = id; }

    public String getEmployeeNumber() { return employeeNumber; }

    public void setEmployeeNumber(String employeeNumber) { this.employeeNumber = employeeNumber; }

    public Integer getDepartmentId() { return departmentId; }

    public void setDepartmentId(Integer departmentId) { this.departmentId = departmentId; }

    public LocalDate getHireDate() { return hireDate; }

    public void setHireDate(LocalDate hireDate) { this.hireDate = hireDate; }

    public String getRoleTitle() { return roleTitle; }

    public void setRoleTitle(String roleTitle) { this.roleTitle = roleTitle; }

    public String getWorkEmail() { return workEmail; }

    public void setWorkEmail(String workEmail) { this.workEmail = workEmail; }

    public String getWorkPhone() { return workPhone; }

    public void setWorkPhone(String workPhone) { this.workPhone = workPhone; }

    public String getStatus() { return status; }

    public void setStatus(String status) { this.status = status; }

    @Override
    public String toString() { return "StaffNonTeaching{"+"id="+id+", emp='"+employeeNumber+'\''+"}"; }
}
