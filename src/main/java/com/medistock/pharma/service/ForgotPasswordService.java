/*
package com.medistock.pharma.service;

import com.medistock.pharma.model.Otp;
import com.medistock.pharma.model.User;
import com.medistock.pharma.repository.OtpRepository;
import com.medistock.pharma.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
@RequiredArgsConstructor
public class ForgotPasswordService {

    private final UserRepository userRepository;

    private final OtpRepository otpRepository;

    private final EmailService emailService;

    private final PasswordEncoder passwordEncoder;

    public String sendOtp(String email) {

        try {

            User user =
                    userRepository.findByEmail(email)
                            .orElseThrow(() ->
                                    new RuntimeException(
                                            "Email Not Found"
                                    ));

            String otp =
                    String.valueOf(
                            100000 +
                                    new Random().nextInt(900000)
                    );

            Otp otpEntity =
                    Otp.builder()
                            .email(email)
                            .otp(otp)
                            .expiryTime(
                                    System.currentTimeMillis()
                                            + 120000
                            )
                            .build();

            otpRepository.save(otpEntity);

            System.out.println("OTP Sending...");

            emailService.sendOtp(
                    email,
                    otp
            );

            System.out.println("OTP Sent Successfully");

            return "OTP Sent";

        } catch (Exception e) {

            e.printStackTrace();

            return e.getMessage();
        }
    }

*/
/*
    public String sendOtp(String email) {

        User user =
                userRepository.findByEmail(email)
                        .orElseThrow(() ->
                                new RuntimeException(
                                        "Email Not Found"
                                ));

        String otp =
                String.valueOf(
                        100000 +
                                new Random().nextInt(900000)
                );

        Otp otpEntity =
                Otp.builder()
                        .email(email)
                        .otp(otp)
                        .expiryTime(
                                System.currentTimeMillis()
                                        + 120000
                        )
                        .build();

        otpRepository.save(otpEntity);

        emailService.sendOtp(
                email,
                otp
        );

        return "OTP Sent";
    }
*//*



    public String verifyOtp(
            String email,
            String otp
    ) {

        Otp savedOtp =
                otpRepository.findByEmail(email)
                        .orElseThrow(() ->
                                new RuntimeException(
                                        "OTP Not Found"
                                ));

        if(System.currentTimeMillis()
                > savedOtp.getExpiryTime()) {

            throw new RuntimeException(
                    "OTP Expired"
            );
        }

        if(!savedOtp.getOtp().equals(otp)) {

            throw new RuntimeException(
                    "Invalid OTP"
            );
        }

        return "OTP Verified";
    }

    public String resetPassword(
            String email,
            String password
    ) {

        User user =
                userRepository.findByEmail(email)
                        .orElseThrow(() ->
                                new RuntimeException(
                                        "User Not Found"
                                ));

        user.setPassword(
                passwordEncoder.encode(password)
        );

        userRepository.save(user);

        otpRepository.findByEmail(email)
                .ifPresent(otpRepository::delete);

        return "Password Reset Successful";
    }
}*/
