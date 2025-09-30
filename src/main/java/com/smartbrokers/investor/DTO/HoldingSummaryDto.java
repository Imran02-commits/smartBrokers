package com.smartbrokers.investor.DTO;

import java.math.BigDecimal;

public class HoldingSummaryDto {
    private String symbol;
    private Long quantity;
    private BigDecimal avgCost;
    private BigDecimal marketPrice;
    private BigDecimal marketValue;
    private BigDecimal costValue;
    private BigDecimal gainLoss;
    private BigDecimal gainLossPercent;

    // getters/setters
    public String getSymbol() { return symbol; }
    public void setSymbol(String symbol) { this.symbol = symbol; }
    public Long getQuantity() { return quantity; }
    public void setQuantity(Long quantity) { this.quantity = quantity; }
    public BigDecimal getAvgCost() { return avgCost; }
    public void setAvgCost(BigDecimal avgCost) { this.avgCost = avgCost; }
    public BigDecimal getMarketPrice() { return marketPrice; }
    public void setMarketPrice(BigDecimal marketPrice) { this.marketPrice = marketPrice; }
    public BigDecimal getMarketValue() { return marketValue; }
    public void setMarketValue(BigDecimal marketValue) { this.marketValue = marketValue; }
    public BigDecimal getCostValue() { return costValue; }
    public void setCostValue(BigDecimal costValue) { this.costValue = costValue; }
    public BigDecimal getGainLoss() { return gainLoss; }
    public void setGainLoss(BigDecimal gainLoss) { this.gainLoss = gainLoss; }
    public BigDecimal getGainLossPercent() { return gainLossPercent; }
    public void setGainLossPercent(BigDecimal gainLossPercent) { this.gainLossPercent = gainLossPercent; }
}

