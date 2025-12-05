package models;

import java.math.BigDecimal;

public class FeeItem {
    private Integer id;
    private String code;
    private String description;
    private BigDecimal amount;
    private Boolean recurring;

    public FeeItem() {}
    public Integer getId() { return id; }

    public void setId(Integer id) { this.id = id; }

    public String getCode() { return code; }

    public void setCode(String code) { this.code = code; }

    public String getDescription() { return description; }

    public void setDescription(String description) { this.description = description; }

    public BigDecimal getAmount() { return amount; }

    public void setAmount(BigDecimal amount) { this.amount = amount; }

    public Boolean getRecurring() { return recurring; }

    public void setRecurring(Boolean recurring) { this.recurring = recurring; }
}
