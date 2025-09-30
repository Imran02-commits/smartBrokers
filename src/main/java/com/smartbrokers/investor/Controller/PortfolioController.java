package com.smartbrokers.investor.Controller;


import com.smartbrokers.investor.DTO.PortfolioSummaryDto;
import com.smartbrokers.investor.Service.PortfolioService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/portfolio")
public class PortfolioController {

    private final PortfolioService portfolioService;

    public PortfolioController(PortfolioService portfolioService) {
        this.portfolioService = portfolioService;
    }

    @GetMapping("/{investorId}")
    public ResponseEntity<PortfolioSummaryDto> getPortfolio(@PathVariable Long investorId) {
        PortfolioSummaryDto dto = portfolioService.getPortfolio(investorId);
        return ResponseEntity.ok(dto);
    }
}


//-- Investors
//INSERT INTO investor (id, name, email) VALUES (1, 'Alice', 'alice@example.com');
//INSERT INTO investor (id, name, email) VALUES (2, 'Bob', 'bob@example.com');
//
//        -- Wallets
//INSERT INTO wallet (id, investor_id, balance) VALUES (1, 1, 10000);
//INSERT INTO wallet (id, investor_id, balance) VALUES (2, 2, 5000);
//
//        -- Holdings
//INSERT INTO holding (id, investor_id, symbol, quantity, avg_cost) VALUES (1, 1, 'AAPL', 10, 150);
//INSERT INTO holding (id, investor_id, symbol, quantity, avg_cost) VALUES (2, 1, 'INFY', 5, 1400);
//INSERT INTO holding (id, investor_id, symbol, quantity, avg_cost) VALUES (3, 2, 'GOOG', 2, 2700);
//INSERT INTO holding (id, investor_id, symbol, quantity, avg_cost) VALUES (4, 2, 'TCS', 3, 3100);


//
//Testing endpoint
//GET http://localhost:8080/api/portfolio/1
//GET http://localhost:8080/api/portfolio/2


//JSOn response
//
//{
//        "investorId": 1,
//        "walletBalance": 10000,
//        "holdings": [
//        {
//        "symbol": "AAPL",
//        "quantity": 10,
//        "avgCost": 150,
//        "marketPrice": 180.5,
//        "marketValue": 1805,
//        "costValue": 1500,
//        "gainLoss": 305,
//        "gainLossPercent": 20.3333
//        },
//        {
//        "symbol": "INFY",
//        "quantity": 5,
//        "avgCost": 1400,
//        "marketPrice": 1500.25,
//        "marketValue": 7501.25,
//        "costValue": 7000,
//        "gainLoss": 501.25,
//        "gainLossPercent": 7.1607
//        }
//        ],
//        "totalMarketValue": 9306.25,
//        "totalCost": 8500,
//        "totalGainLoss": 806.25,
//        "totalGainLossPercent": 9.4882
//        }

