package com.ashutosh.referralapi.model;


import jakarta.persistence.*;


@Entity
@Table(name = "referral")
public class Referral {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "referral_code", nullable = false, length = 20)
    private String referralCode;

    @Column(name = "referred_user_id", nullable = false)
    private Long referredUserId;

    @Column(name = "is_successful")
    private boolean successful=false;

    public Referral() {
    }

    public Referral(Long id, String referrerCode, Long referredUserId, boolean successful) {
        this.id = id;
        this.referralCode = referrerCode;
        this.referredUserId = referredUserId;
        this.successful = successful;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getReferrerCode() {
        return referralCode;
    }

    public void setReferrerCode(String referrerCode) {
        this.referralCode = referrerCode;
    }

    public Long getReferredUserId() {
        return referredUserId;
    }

    public void setReferredUserId(Long referredUserId) {
        this.referredUserId = referredUserId;
    }

    public boolean isSuccessful() {
        return successful;
    }

    public void setSuccessful(boolean successful) {
        this.successful = successful;
    }
}
