package com.smartbrokers.investor.Entity;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
public class Holding {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "investor_id")
    private Investor investor;

    private String symbol;
    private Long quantity;
    private BigDecimal avgCost; // per share

    // getters/setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Investor getInvestor() { return investor; }
    public void setInvestor(Investor investor) { this.investor = investor; }
    public String getSymbol() { return symbol; }
    public void setSymbol(String symbol) { this.symbol = symbol; }
    public Long getQuantity() { return quantity; }
    public void setQuantity(Long quantity) { this.quantity = quantity; }
    public BigDecimal getAvgCost() { return avgCost; }
    public void setAvgCost(BigDecimal avgCost) { this.avgCost = avgCost; }
}

