package com.medistock.pharma.service;

import com.medistock.pharma.model.User;
import com.medistock.pharma.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AdminService {

    private final UserRepository userRepository;

    public List<User> getPendingUsers() {

        return userRepository.findByStatus(
                "PENDING"
        );
    }

    public String approveUser(String id) {

        User user = userRepository.findById(id)
                .orElseThrow();

        user.setApproved(true);

        user.setStatus("ACTIVE");

        userRepository.save(user);

        return "User Approved";
    }

    public String rejectUser(String id) {

        User user = userRepository.findById(id)
                .orElseThrow();

        user.setApproved(false);

        user.setStatus("REJECTED");

        userRepository.save(user);

        return "User Rejected";
    }
}