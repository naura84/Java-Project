package models;

import java.time.LocalDate;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

@Getter
@Setter
@NoArgsConstructor
public class Etudiant {
    private Integer id;
    private String studentNumber;
    private LocalDate admissionDate;
    private Integer programId;
    private String currentLevel;
    private Integer yearAdmitted;
    private String status;
    private Integer scholarshipId;
    private String accommodationDetails;
    private LocalDateTime createdAt;
}
