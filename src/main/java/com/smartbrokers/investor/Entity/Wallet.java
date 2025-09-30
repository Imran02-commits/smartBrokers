package com.smartbrokers.investor.Entity;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
public class Wallet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "investor_id")
    private Investor investor;

    private BigDecimal balance = BigDecimal.ZERO;

    // getters/setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Investor getInvestor() { return investor; }
    public void setInvestor(Investor investor) { this.investor = investor; }
    public BigDecimal getBalance() { return balance; }
    public void setBalance(BigDecimal balance) { this.balance = balance; }
}
