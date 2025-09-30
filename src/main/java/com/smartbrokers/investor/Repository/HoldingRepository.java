package com.smartbrokers.investor.Repository;


import com.smartbrokers.investor.Entity.Holding;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface HoldingRepository extends JpaRepository<Holding, Long> {
    List<Holding> findByInvestorId(Long investorId);
}
