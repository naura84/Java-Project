package models;

import java.time.LocalDateTime;
import java.time.LocalDate;
import java.math.BigDecimal;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class LibraryLoan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "book_id")
    private LibraryBook book;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    private LocalDateTime loanedAt;
    private LocalDate dueDate;
    private LocalDateTime returnedAt;
    private BigDecimal fineAmount;
    private String status;

    @OneToMany(mappedBy = "book")
    private java.util.List<LibraryLoan> loans;
}
