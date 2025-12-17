package models;

import java.time.LocalDateTime;
import jakarta.persistence.*;

@Entity
@Table(name = "classes")
public class SchoolClass {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "program_id")
    private Program program;
    @ManyToOne
    @JoinColumn(name = "academic_year_id")
    private AcademicYear academicYear;
    private String name;
    private String section;
    private Integer capacity;
    @ManyToOne
    @JoinColumn(name = "homeroom_teacher_id")
    private Enseignant homeroomTeacher;
    private LocalDateTime createdAt;

    @OneToMany(mappedBy = "schoolClass")
    private java.util.List<CourseOffering> offerings;

    public SchoolClass() {}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Program getProgram() {
        return program;
    }

    public void setProgram(Program program) {
        this.program = program;
    }

    public AcademicYear getAcademicYear() {
        return academicYear;
    }

    public void setAcademicYear(AcademicYear academicYear) {
        this.academicYear = academicYear;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public Enseignant getHomeroomTeacher() {
        return homeroomTeacher;
    }

    public void setHomeroomTeacher(Enseignant homeroomTeacher) {
        this.homeroomTeacher = homeroomTeacher;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public java.util.List<CourseOffering> getOfferings() {
        return offerings;
    }

    public void setOfferings(java.util.List<CourseOffering> offerings) {
        this.offerings = offerings;
    }
}
