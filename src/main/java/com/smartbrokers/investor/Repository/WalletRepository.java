package com.smartbrokers.investor.Repository;


import com.smartbrokers.investor.Entity.Wallet;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface WalletRepository extends JpaRepository<Wallet, Long> {
    Optional<Wallet> findByInvestorId(Long investorId);
}

