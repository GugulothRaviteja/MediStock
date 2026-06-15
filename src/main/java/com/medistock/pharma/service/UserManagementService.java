package com.medistock.pharma.service;

import com.medistock.pharma.dto.RegisterRequest;
import com.medistock.pharma.dto.UserDTO;
import com.medistock.pharma.model.User;
import com.medistock.pharma.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserManagementService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public List<UserDTO> getAllUsers() {

        return userRepository.findAll()
                .stream()
                .map(user -> new UserDTO(
                        user.getId(),
                        user.getUsername(),
                        user.getEmail(),
                        user.getRole(),
                        user.getStatus()
                ))
                .toList();
    }

    public String createStaff(RegisterRequest request) {

        User user = User.builder()
                .username(request.getUsername())
                .email(request.getEmail())
                .password(
                        passwordEncoder.encode(
                                request.getPassword()
                        )
                )
                .role("STAFF")
                .build();

        userRepository.save(user);

        return "Staff User Created";
    }

    public String deleteUser(String id) {

        userRepository.deleteById(id);

        return "User Deleted";
    }
}