package models;

import java.time.LocalDate;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

@Getter
@Setter
@NoArgsConstructor
public class StaffNonTeaching {
    private Integer id;
    private String employeeNumber;
    private Integer departmentId;
    private LocalDate hireDate;
    private String roleTitle;
    private String workEmail;
    private String workPhone;
    private String status;
}
