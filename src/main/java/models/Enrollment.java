package models;

import java.time.LocalDateTime;
import java.math.BigDecimal;

public class Enrollment {
    private Integer id;
    private Integer studentId;
    private Integer courseOfferingId;
    private LocalDateTime enrolledOn;
    private String status;
    private BigDecimal finalGrade;
    private BigDecimal gradePoint;

    public Enrollment() {}
    public Integer getId() { return id; }

    public void setId(Integer id) { this.id = id; }

    public Integer getStudentId() { return studentId; }

    public void setStudentId(Integer studentId) { this.studentId = studentId; }

    public Integer getCourseOfferingId() { return courseOfferingId; }

    public void setCourseOfferingId(Integer courseOfferingId) { this.courseOfferingId = courseOfferingId; }

    public LocalDateTime getEnrolledOn() { return enrolledOn; }

    public void setEnrolledOn(LocalDateTime enrolledOn) { this.enrolledOn = enrolledOn; }

    public String getStatus() { return status; }

    public void setStatus(String status) { this.status = status; }

    public BigDecimal getFinalGrade() { return finalGrade; }

    public void setFinalGrade(BigDecimal finalGrade) { this.finalGrade = finalGrade; }

    public BigDecimal getGradePoint() { return gradePoint; }

    public void setGradePoint(BigDecimal gradePoint) { this.gradePoint = gradePoint; }
}
