package com.medistock.pharma.controller;

import com.medistock.pharma.dto.RegisterRequest;
import com.medistock.pharma.dto.UserDTO;
import com.medistock.pharma.service.UserManagementService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
@CrossOrigin("*")
public class UserManagementController {

    private final UserManagementService userService;

    @GetMapping
    public List<UserDTO> getAllUsers() {

        return userService.getAllUsers();
    }

    @PostMapping
    public String createStaff(
            @RequestBody RegisterRequest request
    ) {

        return userService.createStaff(request);
    }

    @DeleteMapping("/{id}")
    public String deleteUser(
            @PathVariable String id
    ) {

        return userService.deleteUser(id);
    }
}