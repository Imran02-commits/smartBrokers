package com.smartbrokers.investor.Service;

import java.math.BigDecimal;
import java.util.Map;

import org.springframework.stereotype.Service;

@Service
public class MarketDataService {
    private static final Map<String, BigDecimal> PRICES = Map.of(
            "AAPL", new BigDecimal("180.50"),
            "GOOG", new BigDecimal("2800.75"),
            "INFY", new BigDecimal("1500.25")
    );

    public BigDecimal getPrice(String symbol) {
        return PRICES.getOrDefault(symbol.toUpperCase(), BigDecimal.ZERO);
    }
}

