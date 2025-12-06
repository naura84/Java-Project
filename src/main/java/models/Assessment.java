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
public class Assessment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "course_offering_id")
    private CourseOffering courseOffering;
    @ManyToOne
    @JoinColumn(name = "type_id")
    private AssessmentType type;
    private String title;
    private String description;
    private BigDecimal weight;
    private LocalDateTime date;
    private BigDecimal maxScore;
    private LocalDateTime createdAt;
}
