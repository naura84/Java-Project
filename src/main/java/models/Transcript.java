package models;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

@Getter
@Setter
@NoArgsConstructor
public class Transcript {
    private Integer id;
    private Integer studentId;
    private Integer academicYearId;
    private Integer termId;
    private BigDecimal gpa;
    private String remarks;
    private LocalDateTime generatedAt;
}
