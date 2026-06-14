package com.medistock.pharma.service;

import com.medistock.pharma.config.JwtUtil;
import com.medistock.pharma.dto.LoginRequest;
import com.medistock.pharma.dto.LoginResponse;
import com.medistock.pharma.dto.RegisterRequest;
import com.medistock.pharma.model.User;
import com.medistock.pharma.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;
    private final JavaMailSender mailSender;

    private final Map<String, String> otpStorage =
            new HashMap<>();

    public String register(RegisterRequest request) {

        if (userRepository.findByEmail(request.getEmail()).isPresent()) {
            return "Email already exists";
        }

        User user = User.builder()
                .username(request.getUsername())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .role("STAFF")
                .build();

        userRepository.save(user);

        return "User Registered Successfully";
    }

    public LoginResponse login(LoginRequest request) {

        User user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new RuntimeException("Invalid Email"));

        boolean isPasswordValid = passwordEncoder.matches(
                request.getPassword(),
                user.getPassword()
        );

        if (!isPasswordValid) {
            throw new RuntimeException("Invalid Password");
        }

        String token = jwtUtil.generateToken(user.getEmail());

        return new LoginResponse(
                token,
                user.getRole(),
                user.getUsername()
        );
    }

    public String sendOtp(String email) {

        User user = userRepository
                .findByEmail(email)
                .orElseThrow(() ->
                        new RuntimeException(
                                "Email not found"
                        ));

        String otp = String.valueOf(
                100000 +
                        new Random().nextInt(900000)
        );

        otpStorage.put(email, otp);

        SimpleMailMessage message =
                new SimpleMailMessage();

        message.setTo(email);

        message.setSubject(
                "MediStock Password Reset OTP"
        );

        message.setText(
                "Your OTP is: " + otp
        );

        mailSender.send(message);

        return "OTP Sent Successfully";
    }

    public String verifyOtp(
            String email,
            String otp
    ) {

        String storedOtp =
                otpStorage.get(email);

        if (
                storedOtp == null ||
                        !storedOtp.equals(otp)
        ) {

            throw new RuntimeException(
                    "Invalid OTP"
            );
        }

        return "OTP Verified";
    }

    public String resetPassword(
            String email,
            String newPassword
    ) {

        User user = userRepository
                .findByEmail(email)
                .orElseThrow(() ->
                        new RuntimeException(
                                "User not found"
                        ));

        user.setPassword(
                passwordEncoder.encode(
                        newPassword
                )
        );

        userRepository.save(user);

        otpStorage.remove(email);

        return "Password Reset Successfully";
    }

}