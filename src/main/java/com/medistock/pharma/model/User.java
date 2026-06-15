package com.medistock.pharma.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "users")
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {

    @Id
    private String id;

    private String username;

    private String email;

    private String password;

    private String role;

    private  String otp;
    private String otpExpiryTime;

    private String mobileNumber;
    private  String status;
    private String country;
    private boolean approved;
}