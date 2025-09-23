package com.project.InvestorPortfolio.Repository;

import com.project.InvestorPortfolio.Entity.Investor;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

@Repository

public interface InvestorRepository extends JpaRepository<Investor, Long> {

    boolean existsByEmail(String email);

    boolean existsByMobile(String mobile);

    boolean existsByPan(String pan);

    boolean existsByAadhaar(String aadhaar);

}


