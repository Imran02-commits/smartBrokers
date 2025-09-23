package com.smartbrokers.KYCSubmission.Controller;

import com.smartbrokers.KYCSubmission.Entity.KycDetails;
import com.smartbrokers.KYCSubmission.Service.KycService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/api/kyc")
@RequiredArgsConstructor
public class KycController {

    private final KycService kycService;

    @PostMapping("/submit")
    public ResponseEntity<KycDetails> submitKyc(
            @RequestParam Long investorId,
            @RequestParam MultipartFile pan,
            @RequestParam MultipartFile aadhaar,
            @RequestParam MultipartFile bankProof
    ) throws IOException {
        return ResponseEntity.ok(kycService.submitKyc(investorId, pan, aadhaar, bankProof));
    }

    @GetMapping("/status/{investorId}")
    public ResponseEntity<?> getKycStatus(@PathVariable Long investorId) {
        return kycService.getKycStatus(investorId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
