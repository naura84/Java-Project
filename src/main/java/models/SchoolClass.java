package models;

import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

@Getter
@Setter
@NoArgsConstructor
public class SchoolClass {
    private Integer id;
    private Integer programId;
    private Integer academicYearId;
    private String name;
    private String section;
    private Integer capacity;
    private Integer homeroomTeacherId;
    private LocalDateTime createdAt;
}
