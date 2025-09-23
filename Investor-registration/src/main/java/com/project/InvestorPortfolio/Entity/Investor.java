package com.project.InvestorPortfolio.Entity;

import com.project.InvestorPortfolio.Enums.AccountStatus;
import com.project.InvestorPortfolio.Enums.KycStatus;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

@Entity
@Table(name = "investors")
public class Investor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Name is mandatory")
    private String name;

    @Email(message = "Email should be valid")
    @Column(unique = true)
    private String email;

    @NotBlank(message = "Mobile is mandatory")
    @Column(unique = true)
    private String mobile;

    @NotBlank(message = "PAN is mandatory")
    @Pattern(regexp = "[A-Z]{5}[0-9]{4}[A-Z]{1}", message = "PAN format is invalid")
    @Column(unique = true)
    private String pan;

    @NotBlank(message = "Aadhaar is mandatory")
    @Pattern(regexp = "\\d{12}", message = "Aadhaar must be 12 digits")
    @Column(unique = true)
    private String aadhaar;

    @Enumerated(EnumType.STRING)
    private AccountStatus accountStatus = AccountStatus.PENDING_KYC;

    @Enumerated(EnumType.STRING)
    private KycStatus kycStatus = KycStatus.NOT_SUBMITTED;

    // Getters and Setters

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getMobile() { return mobile; }
    public void setMobile(String mobile) { this.mobile = mobile; }

    public String getPan() { return pan; }
    public void setPan(String pan) { this.pan = pan; }

    public String getAadhaar() { return aadhaar; }
    public void setAadhaar(String aadhaar) { this.aadhaar = aadhaar; }

    public AccountStatus getAccountStatus() { return accountStatus; }

    public void setAccountStatus(AccountStatus accountStatus) {
        this.accountStatus = accountStatus; }

    public KycStatus getKycStatus() { return kycStatus; }

    public void setKycStatus(KycStatus kycStatus) { this.kycStatus = kycStatus; }


}
