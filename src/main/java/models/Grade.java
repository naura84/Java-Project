package models;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

@Getter
@Setter
@NoArgsConstructor
public class Grade {
    private Integer id;
    private Integer assessmentId;
    private Integer studentId;
    private BigDecimal score;
    private String remarks;
    private Integer gradedBy;
    private LocalDateTime gradedAt;
}
