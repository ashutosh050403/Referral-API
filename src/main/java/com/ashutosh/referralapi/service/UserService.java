package com.ashutosh.referralapi.service;


import com.ashutosh.referralapi.dto.ProfileDto;
import com.ashutosh.referralapi.dto.UserDto;
import com.ashutosh.referralapi.model.Referral;
import com.ashutosh.referralapi.model.User;
import com.ashutosh.referralapi.repository.ReferralRepository;
import com.ashutosh.referralapi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ReferralRepository referralRepository;

    public String signup(UserDto userDto) {
        // Check if referral code is provided and valid
        if (userDto.getReferredBy() != null && !userDto.getReferredBy().isEmpty()) {
            Optional<User> referrer = userRepository.findByReferralCode(userDto.getReferredBy());
            if (referrer.isEmpty()) {
                throw new IllegalArgumentException("Invalid referral code.");
            }
        }

        // Generate unique referral code
        String referralCode = UUID.randomUUID().toString().substring(0, 8);

        // Create user
        User user = new User();
        user.setName(userDto.getName());
        user.setEmail(userDto.getEmail());
        user.setReferralCode(referralCode);
        user.setReferredBy(userDto.getReferredBy());

        User savedUser = userRepository.save(user);

        // Save referral record if used a referral code
        if (userDto.getReferredBy() != null && !userDto.getReferredBy().isEmpty()) {
            Referral referral = new Referral();
            referral.setReferrerCode(userDto.getReferredBy());
            referral.setReferredUserId(savedUser.getId());
            referral.setSuccessful(false);
            referralRepository.save(referral);
        }

        return "User signed up successfully with referral code: " + referralCode;
    }

    public String completeProfile(ProfileDto profileDto) {
        Optional<User> optionalUser = userRepository.findById(profileDto.getUserId());
        if (optionalUser.isEmpty()) {
            throw new IllegalArgumentException("User not found.");
        }

        User user = optionalUser.get();
        user.setName(profileDto.getName());
        user.setProfileCompleted(true);
        userRepository.save(user);

        // Mark referral as successful if referred
        if (user.getReferredBy() != null && !user.getReferredBy().isEmpty()) {
            Optional<Referral> referral = referralRepository.findByReferredUserId(user.getId());
            referral.ifPresent(r -> {
                r.setSuccessful(true);
                referralRepository.save(r);
            });
        }

        return "Profile completed successfully.";
    }
}

