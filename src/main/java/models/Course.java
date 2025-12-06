package models;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String code;
    private String title;
    private String description;
    private BigDecimal credits;
    private Integer coefficient;
    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;
    private String level;
    private Boolean elective;
    private String prerequisites;
    private LocalDateTime createdAt;

    @OneToMany(mappedBy = "course")
    private java.util.List<CourseOffering> offerings;
}
