package com.smartbrokers.investor.Repository;

import com.smartbrokers.investor.Entity.Investor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InvestorRepository extends JpaRepository<Investor, Long> {}

