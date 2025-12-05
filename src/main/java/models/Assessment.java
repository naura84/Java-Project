package models;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Assessment {
    private Integer id;
    private Integer courseOfferingId;
    private Integer typeId;
    private String title;
    private String description;
    private BigDecimal weight;
    private LocalDateTime date;
    private BigDecimal maxScore;
    private LocalDateTime createdAt;

    public Assessment() {}
    public Integer getId() { return id; }

    public void setId(Integer id) { this.id = id; }

    public Integer getCourseOfferingId() { return courseOfferingId; }

    public void setCourseOfferingId(Integer courseOfferingId) { this.courseOfferingId = courseOfferingId; }

    public Integer getTypeId() { return typeId; }

    public void setTypeId(Integer typeId) { this.typeId = typeId; }

    public String getTitle() { return title; }

    public void setTitle(String title) { this.title = title; }

    public String getDescription() { return description; }

    public void setDescription(String description) { this.description = description; }

    public BigDecimal getWeight() { return weight; }

    public void setWeight(BigDecimal weight) { this.weight = weight; }

    public LocalDateTime getDate() { return date; }

    public void setDate(LocalDateTime date) { this.date = date; }

    public BigDecimal getMaxScore() { return maxScore; }

    public void setMaxScore(BigDecimal maxScore) { this.maxScore = maxScore; }

    public LocalDateTime getCreatedAt() { return createdAt; }

    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
}
