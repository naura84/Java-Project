package models;

import java.time.LocalDate;
import java.time.LocalDateTime;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Etudiant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String studentNumber;
    private LocalDate admissionDate;
    @ManyToOne
    @JoinColumn(name = "program_id")
    private Program program;
    private String currentLevel;
    private Integer yearAdmitted;
    private String status;
    @ManyToOne
    @JoinColumn(name = "scholarship_id")
    private Scholarship scholarship;
    private String accommodationDetails;
    private LocalDateTime createdAt;
    @OneToOne
    @JoinColumn(name = "id", insertable = false, updatable = false)
    private User user;
}
