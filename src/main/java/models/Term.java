package models;

import java.time.LocalDate;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

@Getter
@Setter
@NoArgsConstructor
public class Term {
    private Integer id;
    private Integer academicYearId;
    private String name;
    private LocalDate startDate;
    private LocalDate endDate;
}
