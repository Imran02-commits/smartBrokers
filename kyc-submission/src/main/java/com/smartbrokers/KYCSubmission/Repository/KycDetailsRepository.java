package com.smartbrokers.KYCSubmission.Repository;

import com.smartbrokers.KYCSubmission.Entity.KycDetails;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface KycDetailsRepository extends JpaRepository<KycDetails, Long> {
    Optional<KycDetails> findByInvestorId(Long investorId);
}
