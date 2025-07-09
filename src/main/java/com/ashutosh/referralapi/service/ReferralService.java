package com.ashutosh.referralapi.service;

import com.ashutosh.referralapi.model.Referral;
import com.ashutosh.referralapi.model.User;
import com.ashutosh.referralapi.repository.ReferralRepository;
import com.ashutosh.referralapi.repository.UserRepository;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Optional;

@Service
public class ReferralService {

    @Autowired
    private ReferralRepository referralRepository;

    @Autowired
    private UserRepository userRepository;

    public List<Referral> getReferrals(String referralCode) {
        System.out.println("Looking up referrals for: " + referralCode);
        List<Referral> list = referralRepository.findByReferralCodeIgnoreCase(referralCode.trim());

        System.out.println("Found " + list.size() + " referrals.");
        return list;
    }


        public void generateReferralCsvReport(HttpServletResponse response) {
            try {
                response.setContentType("text/csv");
                response.setHeader("Content-Disposition", "attachment; filename=\"referral_report.csv\"");
                PrintWriter writer = response.getWriter();

                writer.println("Referrer ID,Referrer Name,Referral Code,Referred User ID,Referred Name,Referred By");

                List<User> users = userRepository.findAll();

                for (User referrer : users) {
                    String code = referrer.getReferralCode();
                    if (code == null || code.trim().isEmpty()) continue;

                    List<User> referredUsers = userRepository.findByReferredByIgnoreCase(code.trim());

                    if (referredUsers.isEmpty()) {
                        writer.printf("%d,%s,%s,,,,%n",
                                referrer.getId(),
                                referrer.getName(),
                                referrer.getReferralCode()
                        );
                    } else {
                        for (User referred : referredUsers) {
                            writer.printf("%d,%s,%s,%d,%s,%s%n",
                                    referrer.getId(),
                                    referrer.getName(),
                                    referrer.getReferralCode(),
                                    referred.getId(),
                                    referred.getName(),
                                    referred.getReferredBy()
                            );
                        }
                    }
                }

                writer.flush();
            } catch (IOException e) {
                throw new RuntimeException("CSV generation failed", e);
            }
        }
    }







