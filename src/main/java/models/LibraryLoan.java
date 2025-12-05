package models;

import java.time.LocalDateTime;
import java.time.LocalDate;
import java.math.BigDecimal;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

@Getter
@Setter
@NoArgsConstructor
public class LibraryLoan {
    private Integer id;
    private Integer bookId;
    private Integer userId;
    private LocalDateTime loanedAt;
    private LocalDate dueDate;
    private LocalDateTime returnedAt;
    private BigDecimal fineAmount;
    private String status;
}
