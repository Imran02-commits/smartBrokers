package com.project.InvestorPortfolio.Controller;


import com.project.InvestorPortfolio.DTO.RegisterInvestorRequest;
import com.project.InvestorPortfolio.Entity.Investor;
import com.project.InvestorPortfolio.Service.InvestorService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class InvestorController {

    @Autowired
    private InvestorService investorService;

    @PostMapping("/register")
    public ResponseEntity<?> registerInvestor(@Valid @RequestBody RegisterInvestorRequest request) {
        try {
            Investor investor = investorService.registerInvestor(request);
            return ResponseEntity.ok().body("Registration successful. Status: " + investor.getKycStatus());
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("An unexpected error occurred");
        }
    }
}
