package models;

import java.time.LocalDateTime;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Setter
@NoArgsConstructor
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
}
