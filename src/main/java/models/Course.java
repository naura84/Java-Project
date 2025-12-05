package models;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Course {
    private Integer id;
    private String code;
    private String title;
    private String description;
    private BigDecimal credits;
    private Integer coefficient;
    private Integer departmentId;
    private String level;
    private Boolean elective;
    private String prerequisites;
    private LocalDateTime createdAt;

    public Course() {}
    public Integer getId() { return id; }

    public void setId(Integer id) { this.id = id; }

    public String getCode() { return code; }

    public void setCode(String code) { this.code = code; }

    public String getTitle() { return title; }

    public void setTitle(String title) { this.title = title; }

    public String getDescription() { return description; }

    public void setDescription(String description) { this.description = description; }

    public BigDecimal getCredits() { return credits; }

    public void setCredits(BigDecimal credits) { this.credits = credits; }

    public Integer getCoefficient() { return coefficient; }

    public void setCoefficient(Integer coefficient) { this.coefficient = coefficient; }

    public Integer getDepartmentId() { return departmentId; }

    public void setDepartmentId(Integer departmentId) { this.departmentId = departmentId; }

    public String getLevel() { return level; }

    public void setLevel(String level) { this.level = level; }

    public Boolean getElective() { return elective; }

    public void setElective(Boolean elective) { this.elective = elective; }

    public String getPrerequisites() { return prerequisites; }

    public void setPrerequisites(String prerequisites) { this.prerequisites = prerequisites; }

    public LocalDateTime getCreatedAt() { return createdAt; }

    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
}
