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
public class CourseOffering {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;
    @ManyToOne
    @JoinColumn(name = "term_id")
    private Term term;
    @ManyToOne
    @JoinColumn(name = "instructor_id")
    private Enseignant instructor;
    @ManyToOne
    @JoinColumn(name = "class_id")
    private SchoolClass schoolClass;
    @ManyToOne
    @JoinColumn(name = "room_id")
    private Room room;
    private String schedule; // JSON as String
    private Integer maxCapacity;
    private Integer enrolledCount;
    private String status;
    private LocalDateTime createdAt;
}
