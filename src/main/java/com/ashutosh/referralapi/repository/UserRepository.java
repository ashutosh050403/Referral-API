package com.ashutosh.referralapi.repository;

import com.ashutosh.referralapi.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByReferralCode(String referralCode);
    List<User> findByReferredByIgnoreCase(String referredBy);

}

