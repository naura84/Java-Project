package models;

import java.time.LocalDateTime;

public class SchoolClass {
    private Integer id;
    private Integer programId;
    private Integer academicYearId;
    private String name;
    private String section;
    private Integer capacity;
    private Integer homeroomTeacherId;
    private LocalDateTime createdAt;

    public SchoolClass() {}
    public Integer getId() { return id; }

    public void setId(Integer id) { this.id = id; }

    public Integer getProgramId() { return programId; }

    public void setProgramId(Integer programId) { this.programId = programId; }

    public Integer getAcademicYearId() { return academicYearId; }

    public void setAcademicYearId(Integer academicYearId) { this.academicYearId = academicYearId; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public String getSection() { return section; }

    public void setSection(String section) { this.section = section; }

    public Integer getCapacity() { return capacity; }

    public void setCapacity(Integer capacity) { this.capacity = capacity; }

    public Integer getHomeroomTeacherId() { return homeroomTeacherId; }

    public void setHomeroomTeacherId(Integer homeroomTeacherId) { this.homeroomTeacherId = homeroomTeacherId; }

    public LocalDateTime getCreatedAt() { return createdAt; }

    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
}
