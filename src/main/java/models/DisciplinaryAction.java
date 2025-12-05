package models;

import java.time.LocalDate;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

@Getter
@Setter
@NoArgsConstructor
public class DisciplinaryAction {
    private Integer id;
    private Integer studentId;
    private Integer reportedBy;
    private LocalDate incidentDate;
    private String category;
    private String description;
    private String actionTaken;
    private String status;
    private LocalDateTime createdAt;
}
