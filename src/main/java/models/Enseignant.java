package models;

import java.time.LocalDate;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

@Getter
@Setter
@NoArgsConstructor
public class Enseignant {
    private Integer id;
    private String employeeNumber;
    private Integer departmentId;
    private LocalDate hireDate;
    private String jobTitle;
    private String specialization;
    private String workEmail;
    private String workPhone;
    private String status;
    private LocalDateTime createdAt;
}
