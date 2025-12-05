package models;

import java.math.BigDecimal;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

@Getter
@Setter
@NoArgsConstructor
public class GradeScale {
    private Integer id;
    private String name;
    private BigDecimal minScore;
    private BigDecimal maxScore;
    private String gradeLabel;
    private BigDecimal gradePoint;
}
