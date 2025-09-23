package com.smartBrokers.fund_manager_approval.service;

import java.util.List;
import org.springframework.stereotype.Service;

import com.smartBrokers.fund_manager_approval.entity.Investor;
import com.smartBrokers.fund_manager_approval.entity.KycStatus;
import com.smartBrokers.fund_manager_approval.repository.InvestorRepository;

import lombok.*;
@Service
@AllArgsConstructor
public class InvestorApprovalService {
	
    private final InvestorRepository investorRepo;

    public List<Investor> getPendingInvestors() {
        return investorRepo.findByStatus(KycStatus.PENDING);
    }

    public Investor approveInvestor(Long id) {
        Investor inv = investorRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Investor not found"));
        inv.setStatus(KycStatus.ACTIVE);
        return investorRepo.save(inv);
    }

    public Investor rejectInvestor(Long id, String comments) {
        Investor inv = investorRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Investor not found"));
        inv.setStatus(KycStatus.REJECTED);
        return investorRepo.save(inv);
    }
}

