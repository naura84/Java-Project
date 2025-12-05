package models;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

@Getter
@Setter
@NoArgsConstructor
public class Assessment {
    private Integer id;
    private Integer courseOfferingId;
    private Integer typeId;
    private String title;
    private String description;
    private BigDecimal weight;
    private LocalDateTime date;
    private BigDecimal maxScore;
    private LocalDateTime createdAt;
}
