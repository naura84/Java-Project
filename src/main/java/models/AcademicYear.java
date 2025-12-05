package models;

import java.time.LocalDate;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

@Getter
@Setter
@NoArgsConstructor
public class AcademicYear {
    private Integer id;
    private String name;
    private LocalDate startDate;
    private LocalDate endDate;
    private Boolean active;
}
