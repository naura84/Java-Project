package models;

import java.time.LocalDate;

public class Term {
    private Integer id;
    private Integer academicYearId;
    private String name;
    private LocalDate startDate;
    private LocalDate endDate;

    public Term() {}
    public Integer getId() { return id; }

    public void setId(Integer id) { this.id = id; }

    public Integer getAcademicYearId() { return academicYearId; }

    public void setAcademicYearId(Integer academicYearId) { this.academicYearId = academicYearId; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public LocalDate getStartDate() { return startDate; }

    public void setStartDate(LocalDate startDate) { this.startDate = startDate; }

    public LocalDate getEndDate() { return endDate; }

    public void setEndDate(LocalDate endDate) { this.endDate = endDate; }
}
