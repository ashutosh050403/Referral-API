package com.ashutosh.referralapi.repository;

import com.ashutosh.referralapi.model.Referral;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ReferralRepository extends JpaRepository<Referral, Long> {

    List<Referral> findByReferralCodeIgnoreCase(String referralCode);


    Optional<Referral> findByReferredUserId(Long referredUserId);


}

