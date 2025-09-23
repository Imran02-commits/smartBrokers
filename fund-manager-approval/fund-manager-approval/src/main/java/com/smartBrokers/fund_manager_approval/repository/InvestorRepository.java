package com.smartBrokers.fund_manager_approval.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.smartBrokers.fund_manager_approval.entity.Investor;
import com.smartBrokers.fund_manager_approval.entity.KycStatus;

public interface InvestorRepository extends JpaRepository<Investor, Long>
{
	 List<Investor> findByStatus(KycStatus status);
	

}
