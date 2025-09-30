package com.smartbrokers.investor.Entity;


import jakarta.persistence.*;
        import java.util.List;

@Entity
public class Investor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;

    @OneToMany(mappedBy = "investor", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Holding> holdings;

    @OneToOne(mappedBy = "investor", cascade = CascadeType.ALL)
    private Wallet wallet;

    // getters/setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public List<Holding> getHoldings() { return holdings; }
    public void setHoldings(List<Holding> holdings) { this.holdings = holdings; }
    public Wallet getWallet() { return wallet; }
    public void setWallet(Wallet wallet) { this.wallet = wallet; }
}

