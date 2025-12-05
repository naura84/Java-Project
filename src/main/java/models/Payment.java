package models;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

@Getter
@Setter
@NoArgsConstructor
public class Payment {
    private Integer id;
    private Integer invoiceId;
    private Integer studentId;
    private BigDecimal amount;
    private String method;
    private LocalDateTime paidAt;
    private String reference;
    private Integer processedBy;
}
