package models;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Grade {
    private Integer id;
    private Integer assessmentId;
    private Integer studentId;
    private BigDecimal score;
    private String remarks;
    private Integer gradedBy;
    private LocalDateTime gradedAt;

    public Grade() {}
    public Integer getId() { return id; }

    public void setId(Integer id) { this.id = id; }

    public Integer getAssessmentId() { return assessmentId; }

    public void setAssessmentId(Integer assessmentId) { this.assessmentId = assessmentId; }

    public Integer getStudentId() { return studentId; }

    public void setStudentId(Integer studentId) { this.studentId = studentId; }

    public BigDecimal getScore() { return score; }

    public void setScore(BigDecimal score) { this.score = score; }

    public String getRemarks() { return remarks; }

    public void setRemarks(String remarks) { this.remarks = remarks; }

    public Integer getGradedBy() { return gradedBy; }

    public void setGradedBy(Integer gradedBy) { this.gradedBy = gradedBy; }

    public LocalDateTime getGradedAt() { return gradedAt; }

    public void setGradedAt(LocalDateTime gradedAt) { this.gradedAt = gradedAt; }
}
