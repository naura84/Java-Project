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
public class Enseignant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String employeeNumber;
    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;
    private LocalDate hireDate;
    private String jobTitle;
    private String specialization;
    private String workEmail;
    private String workPhone;
    private String status;
    private LocalDateTime createdAt;
    @OneToOne
    @JoinColumn(name = "id", insertable = false, updatable = false)
    private User user;
}
