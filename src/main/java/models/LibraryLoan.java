package models;

import java.time.LocalDateTime;
import java.time.LocalDate;
import java.math.BigDecimal;

public class LibraryLoan {
    private Integer id;
    private Integer bookId;
    private Integer userId;
    private LocalDateTime loanedAt;
    private LocalDate dueDate;
    private LocalDateTime returnedAt;
    private BigDecimal fineAmount;
    private String status;

    public LibraryLoan() {}
    public Integer getId() { return id; }

    public void setId(Integer id) { this.id = id; }

    public Integer getBookId() { return bookId; }

    public void setBookId(Integer bookId) { this.bookId = bookId; }

    public Integer getUserId() { return userId; }

    public void setUserId(Integer userId) { this.userId = userId; }

    public LocalDateTime getLoanedAt() { return loanedAt; }

    public void setLoanedAt(LocalDateTime loanedAt) { this.loanedAt = loanedAt; }

    public LocalDate getDueDate() { return dueDate; }

    public void setDueDate(LocalDate dueDate) { this.dueDate = dueDate; }

    public LocalDateTime getReturnedAt() { return returnedAt; }

    public void setReturnedAt(LocalDateTime returnedAt) { this.returnedAt = returnedAt; }

    public BigDecimal getFineAmount() { return fineAmount; }

    public void setFineAmount(BigDecimal fineAmount) { this.fineAmount = fineAmount; }

    public String getStatus() { return status; }

    public void setStatus(String status) { this.status = status; }
}
