package models;

import java.math.BigDecimal;

public class GradeScale {
    private Integer id;
    private String name;
    private BigDecimal minScore;
    private BigDecimal maxScore;
    private String gradeLabel;
    private BigDecimal gradePoint;

    public GradeScale() {}
    public Integer getId() { return id; }

    public void setId(Integer id) { this.id = id; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public BigDecimal getMinScore() { return minScore; }

    public void setMinScore(BigDecimal minScore) { this.minScore = minScore; }

    public BigDecimal getMaxScore() { return maxScore; }

    public void setMaxScore(BigDecimal maxScore) { this.maxScore = maxScore; }

    public String getGradeLabel() { return gradeLabel; }

    public void setGradeLabel(String gradeLabel) { this.gradeLabel = gradeLabel; }

    public BigDecimal getGradePoint() { return gradePoint; }

    public void setGradePoint(BigDecimal gradePoint) { this.gradePoint = gradePoint; }
}
