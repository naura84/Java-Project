package models;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

@Getter
@Setter
@NoArgsConstructor
public class Course {
    private Integer id;
    private String code;
    private String title;
    private String description;
    private BigDecimal credits;
    private Integer coefficient;
    private Integer departmentId;
    private String level;
    private Boolean elective;
    private String prerequisites;
    private LocalDateTime createdAt;
}
