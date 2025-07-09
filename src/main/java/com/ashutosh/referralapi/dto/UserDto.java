package com.ashutosh.referralapi.dto;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;


public class UserDto {

    @NotBlank(message = "Name is required")
    private String name;

    @Email(message = "Enter a valid email")
    @NotBlank(message = "Email is required")
    private String email;

    // Optional referral code (can be null or empty)
    private String referredBy;

    public UserDto() {
    }

    public UserDto(String name, String email, String referredBy) {
        this.name = name;
        this.email = email;
        this.referredBy = referredBy;
    }

    public @NotBlank(message = "Name is required") String getName() {
        return name;
    }

    public void setName(@NotBlank(message = "Name is required") String name) {
        this.name = name;
    }

    public @Email(message = "Enter a valid email") @NotBlank(message = "Email is required") String getEmail() {
        return email;
    }

    public void setEmail(@Email(message = "Enter a valid email") @NotBlank(message = "Email is required") String email) {
        this.email = email;
    }

    public String getReferredBy() {
        return referredBy;
    }

    public void setReferredBy(String referredBy) {
        this.referredBy = referredBy;
    }
}


