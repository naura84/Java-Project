package models;

import java.math.BigDecimal;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

@Getter
@Setter
@NoArgsConstructor
public class Scholarship {
    private Integer id;
    private String name;
    private String description;
    private BigDecimal amount;
    private String criteria; // JSON
}
