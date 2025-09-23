package com.smartbrokers.KYCSubmission.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "kyc_details")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class KycDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long investorId;

    private String panFilePath;
    private String aadhaarFilePath;
    private String bankProofFilePath;

    private String status; // UNDER_REVIEW, APPROVED, REJECTED

    private LocalDateTime submittedAt;
}
