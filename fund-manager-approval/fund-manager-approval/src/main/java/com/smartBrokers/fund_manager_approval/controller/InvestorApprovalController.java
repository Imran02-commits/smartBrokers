package com.smartBrokers.fund_manager_approval.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.smartBrokers.fund_manager_approval.entity.Investor;
import com.smartBrokers.fund_manager_approval.service.InvestorApprovalService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/fundmanager")
@RequiredArgsConstructor
public class InvestorApprovalController {
	
    private final InvestorApprovalService service;

    @GetMapping("/pending-investors")
    public List<Investor> getPendingInvestors() {
        return service.getPendingInvestors();
    }

    @PostMapping("/approve/{id}")
    public Investor approveInvestor(@PathVariable Long id) {
        return service.approveInvestor(id);
    }

    @PostMapping("/reject/{id}")
    public Investor rejectInvestor(@PathVariable Long id,
                                   @RequestParam String comments) {
        return service.rejectInvestor(id, comments);
    }
}

