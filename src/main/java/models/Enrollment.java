package models;

import java.time.LocalDateTime;
import java.math.BigDecimal;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

@Getter
@Setter
@NoArgsConstructor
public class Enrollment {
    private Integer id;
    private Integer studentId;
    private Integer courseOfferingId;
    private LocalDateTime enrolledOn;
    private String status;
    private BigDecimal finalGrade;
    private BigDecimal gradePoint;
}
