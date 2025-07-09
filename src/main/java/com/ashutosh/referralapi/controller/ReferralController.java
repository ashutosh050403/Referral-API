package com.ashutosh.referralapi.controller;

import com.ashutosh.referralapi.service.ReferralService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/referrals")
public class ReferralController {

    @Autowired
    private ReferralService referralService;

    @GetMapping("/code/{referralCode}")
    public ResponseEntity<?> getReferrals(@PathVariable String referralCode) {
        return ResponseEntity.ok(referralService.getReferrals(referralCode));
    }

    @GetMapping("/full-report")
    public void generateUserReferralReport(HttpServletResponse response) {
        referralService.generateReferralCsvReport(response);
    }

}

