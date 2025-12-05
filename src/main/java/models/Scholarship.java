package models;

import java.math.BigDecimal;

public class Scholarship {
    private Integer id;
    private String name;
    private String description;
    private BigDecimal amount;
    private String criteria; // JSON

    public Scholarship() {}
    public Integer getId() { return id; }

    public void setId(Integer id) { this.id = id; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public String getDescription() { return description; }

    public void setDescription(String description) { this.description = description; }

    public BigDecimal getAmount() { return amount; }

    public void setAmount(BigDecimal amount) { this.amount = amount; }

    public String getCriteria() { return criteria; }

    public void setCriteria(String criteria) { this.criteria = criteria; }
}
