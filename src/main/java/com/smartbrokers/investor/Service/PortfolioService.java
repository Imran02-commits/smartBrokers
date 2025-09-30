package com.smartbrokers.investor.Service;



import com.smartbrokers.investor.DTO.HoldingSummaryDto;
import com.smartbrokers.investor.DTO.PortfolioSummaryDto;
import com.smartbrokers.investor.Entity.Holding;
import com.smartbrokers.investor.Entity.Wallet;
import com.smartbrokers.investor.Repository.HoldingRepository;
import com.smartbrokers.investor.Repository.WalletRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
public class PortfolioService {

    private final HoldingRepository holdingRepo;
    private final WalletRepository walletRepo;
    private final MarketDataService marketData;

    public PortfolioService(HoldingRepository holdingRepo,
                            WalletRepository walletRepo,
                            MarketDataService marketData) {
        this.holdingRepo = holdingRepo;
        this.walletRepo = walletRepo;
        this.marketData = marketData;
    }

    public PortfolioSummaryDto getPortfolio(Long investorId) {

        List<Holding> holdings = holdingRepo.findByInvestorId(investorId);
        Wallet wallet = walletRepo.findByInvestorId(investorId).orElse(new Wallet());

        List<HoldingSummaryDto> holdingDtos = new ArrayList<>();
        BigDecimal totalMarket = BigDecimal.ZERO;
        BigDecimal totalCost = BigDecimal.ZERO;

        for (Holding h : holdings) {
            BigDecimal price = marketData.getPrice(h.getSymbol());
            BigDecimal marketValue = price.multiply(BigDecimal.valueOf(h.getQuantity()));
            BigDecimal costValue = h.getAvgCost().multiply(BigDecimal.valueOf(h.getQuantity()));
            BigDecimal gainLoss = marketValue.subtract(costValue);
            BigDecimal gainLossPercent = costValue.compareTo(BigDecimal.ZERO) > 0
                    ? gainLoss.divide(costValue, 4, BigDecimal.ROUND_HALF_UP).multiply(new BigDecimal("100"))
                    : BigDecimal.ZERO;

            HoldingSummaryDto hs = new HoldingSummaryDto();
            hs.setSymbol(h.getSymbol());
            hs.setQuantity(h.getQuantity());
            hs.setAvgCost(h.getAvgCost());
            hs.setMarketPrice(price);
            hs.setMarketValue(marketValue);
            hs.setCostValue(costValue);
            hs.setGainLoss(gainLoss);
            hs.setGainLossPercent(gainLossPercent);

            holdingDtos.add(hs);

            totalMarket = totalMarket.add(marketValue);
            totalCost = totalCost.add(costValue);
        }

        BigDecimal totalGain = totalMarket.subtract(totalCost);
        BigDecimal totalGainPercent = totalCost.compareTo(BigDecimal.ZERO) > 0
                ? totalGain.divide(totalCost, 4, BigDecimal.ROUND_HALF_UP).multiply(new BigDecimal("100"))
                : BigDecimal.ZERO;

        PortfolioSummaryDto dto = new PortfolioSummaryDto();
        dto.setInvestorId(investorId);
        dto.setWalletBalance(wallet.getBalance());
        dto.setHoldings(holdingDtos);
        dto.setTotalMarketValue(totalMarket);
        dto.setTotalCost(totalCost);
        dto.setTotalGainLoss(totalGain);
        dto.setTotalGainLossPercent(totalGainPercent);

        return dto;
    }
}
