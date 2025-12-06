package models;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "invoice_id")
    private Invoice invoice;
    @ManyToOne
    @JoinColumn(name = "student_id")
    private Etudiant student;
    private BigDecimal amount;
    private String method;
    private LocalDateTime paidAt;
    private String reference;
    @ManyToOne
    @JoinColumn(name = "processed_by")
    private User processedBy;
}
