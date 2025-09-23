package com.smartbrokers.KYCSubmission.Service;

import com.smartbrokers.KYCSubmission.Entity.KycDetails;
import com.smartbrokers.KYCSubmission.Repository.KycDetailsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class KycService {

    private final KycDetailsRepository kycRepo;
    private final String uploadDir = "uploads/kyc/";

    public KycDetails submitKyc(Long investorId, MultipartFile pan, MultipartFile aadhaar, MultipartFile bankProof) throws IOException {
        // Create upload folder if not exists
        File dir = new File(uploadDir);
        if (!dir.exists()) dir.mkdirs();

        // Save files locally
        String panPath = saveFile(pan);
        String aadhaarPath = saveFile(aadhaar);
        String bankProofPath = saveFile(bankProof);

        // Create entity
        KycDetails kyc = KycDetails.builder()
                .investorId(investorId)
                .panFilePath(panPath)
                .aadhaarFilePath(aadhaarPath)
                .bankProofFilePath(bankProofPath)
                .status("UNDER_REVIEW")
                .submittedAt(LocalDateTime.now())
                .build();

        return kycRepo.save(kyc);
    }

    public Optional<KycDetails> getKycStatus(Long investorId) {
        return kycRepo.findByInvestorId(investorId);
    }

    private String saveFile(MultipartFile file) throws IOException {
        String filePath = uploadDir + System.currentTimeMillis() + "_" + file.getOriginalFilename();
        file.transferTo(new File(filePath));
        return filePath;
    }
}