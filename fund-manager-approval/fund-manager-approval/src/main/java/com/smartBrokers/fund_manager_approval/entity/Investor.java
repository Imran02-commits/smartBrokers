package com.smartBrokers.fund_manager_approval.entity;

//package com.smartBrokers.fund_manager_approval.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Investor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;

    @Enumerated(EnumType.STRING)
    private KycStatus status; // PENDING, ACTIVE, REJECTED

	
}
