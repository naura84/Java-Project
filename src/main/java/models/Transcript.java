package models;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Transcript {
    private Integer id;
    private Integer studentId;
    private Integer academicYearId;
    private Integer termId;
    private BigDecimal gpa;
    private String remarks;
    private LocalDateTime generatedAt;

    public Transcript() {}
    public Integer getId() { return id; }

    public void setId(Integer id) { this.id = id; }

    public Integer getStudentId() { return studentId; }

    public void setStudentId(Integer studentId) { this.studentId = studentId; }

    public Integer getAcademicYearId() { return academicYearId; }

    public void setAcademicYearId(Integer academicYearId) { this.academicYearId = academicYearId; }

    public Integer getTermId() { return termId; }

    public void setTermId(Integer termId) { this.termId = termId; }

    public BigDecimal getGpa() { return gpa; }

    public void setGpa(BigDecimal gpa) { this.gpa = gpa; }

    public String getRemarks() { return remarks; }

    public void setRemarks(String remarks) { this.remarks = remarks; }

    public LocalDateTime getGeneratedAt() { return generatedAt; }

    public void setGeneratedAt(LocalDateTime generatedAt) { this.generatedAt = generatedAt; }
}
