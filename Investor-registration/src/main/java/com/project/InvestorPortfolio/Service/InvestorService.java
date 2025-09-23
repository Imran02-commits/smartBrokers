package com.project.InvestorPortfolio.Service;

import com.project.InvestorPortfolio.DTO.RegisterInvestorRequest;
import com.project.InvestorPortfolio.Entity.Investor;
import com.project.InvestorPortfolio.Enums.AccountStatus;
import com.project.InvestorPortfolio.Enums.KycStatus;
import com.project.InvestorPortfolio.Repository.InvestorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class InvestorService {

    @Autowired
    private InvestorRepository investorRepository;

    // Stub for email sender - replace with real implementation
    private void sendConfirmationEmail(Investor investor) {
        System.out.println("Sending confirmation email to " + investor.getEmail());
        // TODO: Integrate JavaMailSender here
    }

    @Transactional
    public Investor registerInvestor(RegisterInvestorRequest request) throws IllegalArgumentException {
        // Check for duplicates
        if (investorRepository.existsByEmail(request.getEmail()))
            throw new IllegalArgumentException("Email already registered");
        if (investorRepository.existsByMobile(request.getMobile()))
            throw new IllegalArgumentException("Mobile already registered");
        if (investorRepository.existsByPan(request.getPan()))
            throw new IllegalArgumentException("PAN already registered");
        if (investorRepository.existsByAadhaar(request.getAadhaar()))
            throw new IllegalArgumentException("Aadhaar already registered");

        Investor investor = new Investor();
        investor.setName(request.getName());
        investor.setEmail(request.getEmail());
        investor.setMobile(request.getMobile());
        investor.setPan(request.getPan());
        investor.setAadhaar(request.getAadhaar());

        // Set initial statuses
        investor.setAccountStatus(AccountStatus.PENDING_KYC);
        investor.setKycStatus(KycStatus.NOT_SUBMITTED);

        Investor savedInvestor = investorRepository.save(investor);

        sendConfirmationEmail(savedInvestor);

        return savedInvestor;
    }
}
