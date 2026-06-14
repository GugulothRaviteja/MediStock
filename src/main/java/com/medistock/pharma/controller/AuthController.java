/*
package com.medistock.pharma.controller;


import com.medistock.pharma.dto.LoginRequest;
import com.medistock.pharma.dto.LoginResponse;

import com.medistock.pharma.dto.RegisterRequest;
import com.medistock.pharma.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
@CrossOrigin("*")
public class AuthController {

    private final AuthService authService;

    @PostMapping("/register")
    public String register(@RequestBody RegisterRequest request) {

        return authService.register(request);
    }

    @PostMapping("/login")
    public LoginResponse login(
            @RequestBody LoginRequest request
    ) {

        return authService.login(request);
    }

}
*/

package com.medistock.pharma.controller;

import com.medistock.pharma.dto.LoginRequest;
import com.medistock.pharma.dto.LoginResponse;
import com.medistock.pharma.dto.RegisterRequest;
import com.medistock.pharma.dto.VerifyOtpRequest;
import com.medistock.pharma.dto.ResetPasswordRequest;
import com.medistock.pharma.service.AuthService;

import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
@CrossOrigin("*")
public class AuthController {

    private final AuthService authService;

    @PostMapping("/register")
    public String register(
            @RequestBody RegisterRequest request
    ) {

        return authService.register(request);
    }

    @PostMapping("/login")
    public LoginResponse login(
            @RequestBody LoginRequest request
    ) {

        return authService.login(request);
    }

    // SEND OTP

    @PostMapping("/send-otp")
    public String sendOtp(
            @RequestBody VerifyOtpRequest request
    ) {

        return authService.sendOtp(
                request.getEmail()
        );
    }

    // VERIFY OTP

    @PostMapping("/verify-otp")
    public String verifyOtp(
            @RequestBody VerifyOtpRequest request
    ) {

        return authService.verifyOtp(
                request.getEmail(),
                request.getOtp()
        );
    }

    // RESET PASSWORD

    @PostMapping("/reset-password")
    public String resetPassword(
            @RequestBody ResetPasswordRequest request
    ) {

        return authService.resetPassword(
                request.getEmail(),
                request.getNewPassword()
        );
    }
}