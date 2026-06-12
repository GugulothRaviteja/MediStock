/*
package com.medistock.pharma.service;

import lombok.RequiredArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmailService {

    private final JavaMailSender mailSender;

    public void sendOtp(
            String email,
            String otp
    ) {

        SimpleMailMessage message =
                new SimpleMailMessage();

        message.setFrom(
                "gugulothraviteja111213@gmail.com"
        );

        message.setTo(email);

        message.setSubject(
                "MediStock Password Reset OTP"
        );

        message.setText(
                "Your OTP is : " + otp
        );

        mailSender.send(message);
    }

    */
/*public void sendOtp(
            String email,
            String otp
    ) {

        SimpleMailMessage message =
                new SimpleMailMessage();

        message.setTo(email);

        message.setSubject(
                "MediStock Password Reset OTP"
        );

        message.setText(
                "Your OTP is : " + otp
        );

        mailSender.send(message);
    }*//*

}*/
