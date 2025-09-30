package com.smartbrokers.investor.DTO;

import java.math.BigDecimal;
import java.util.List;

public class PortfolioSummaryDto {
    private Long investorId;
    private BigDecimal walletBalance;
    private List<HoldingSummaryDto> holdings;
    private BigDecimal totalMarketValue;
    private BigDecimal totalCost;
    private BigDecimal totalGainLoss;
    private BigDecimal totalGainLossPercent;

    // getters/setters
    public Long getInvestorId() { return investorId; }
    public void setInvestorId(Long investorId) { this.investorId = investorId; }
    public BigDecimal getWalletBalance() { return walletBalance; }
    public void setWalletBalance(BigDecimal walletBalance) { this.walletBalance = walletBalance; }
    public List<HoldingSummaryDto> getHoldings() { return holdings; }
    public void setHoldings(List<HoldingSummaryDto> holdings) { this.holdings = holdings; }
    public BigDecimal getTotalMarketValue() { return totalMarketValue; }
    public void setTotalMarketValue(BigDecimal totalMarketValue) { this.totalMarketValue = totalMarketValue; }
    public BigDecimal getTotalCost() { return totalCost; }
    public void setTotalCost(BigDecimal totalCost) { this.totalCost = totalCost; }
    public BigDecimal getTotalGainLoss() { return totalGainLoss; }
    public void setTotalGainLoss(BigDecimal totalGainLoss) { this.totalGainLoss = totalGainLoss; }
    public BigDecimal getTotalGainLossPercent() { return totalGainLossPercent; }
    public void setTotalGainLossPercent(BigDecimal totalGainLossPercent) { this.totalGainLossPercent = totalGainLossPercent; }
}

