package models;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Payment {
    private Integer id;
    private Integer invoiceId;
    private Integer studentId;
    private BigDecimal amount;
    private String method;
    private LocalDateTime paidAt;
    private String reference;
    private Integer processedBy;

    public Payment() {}
    public Integer getId() { return id; }

    public void setId(Integer id) { this.id = id; }

    public Integer getInvoiceId() { return invoiceId; }

    public void setInvoiceId(Integer invoiceId) { this.invoiceId = invoiceId; }

    public Integer getStudentId() { return studentId; }

    public void setStudentId(Integer studentId) { this.studentId = studentId; }

    public BigDecimal getAmount() { return amount; }

    public void setAmount(BigDecimal amount) { this.amount = amount; }

    public String getMethod() { return method; }

    public void setMethod(String method) { this.method = method; }

    public LocalDateTime getPaidAt() { return paidAt; }

    public void setPaidAt(LocalDateTime paidAt) { this.paidAt = paidAt; }

    public String getReference() { return reference; }

    public void setReference(String reference) { this.reference = reference; }

    public Integer getProcessedBy() { return processedBy; }

    public void setProcessedBy(Integer processedBy) { this.processedBy = processedBy; }
}
