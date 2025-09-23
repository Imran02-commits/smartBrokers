package com.project.InvestorPortfolio.DTO;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public class RegisterInvestorRequest {

    @NotBlank(message = "Name is mandatory")
    private String name;

    @Email(message = "Email should be valid")
    private String email;

    @NotBlank(message = "Mobile is mandatory")
    private String mobile;

    @NotBlank(message = "PAN is mandatory")
    @Pattern(regexp = "[A-Z]{5}[0-9]{4}[A-Z]{1}", message = "PAN format is invalid")
    private String pan;

    @NotBlank(message = "Aadhaar is mandatory")
    @Pattern(regexp = "\\d{12}", message = "Aadhaar must be 12 digits")
    private String aadhaar;

    // Getters and setters

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


}
