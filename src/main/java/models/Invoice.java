package models;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

@Getter
@Setter
@NoArgsConstructor
public class Invoice {
    private Integer id;
    private Integer studentId;
    private String invoiceNumber;
    private LocalDate issueDate;
    private LocalDate dueDate;
    private BigDecimal totalAmount;
    private String status;
    private String details; // JSON
    private LocalDateTime createdAt;
}
