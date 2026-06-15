package com.medistock.pharma.controller;

import com.medistock.pharma.model.User;
import com.medistock.pharma.service.AdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
@RequiredArgsConstructor
@CrossOrigin("*")
public class AdminController {

    private final AdminService adminService;

    @GetMapping("/pending-users")
    public List<User> getPendingUsers() {

        return adminService.getPendingUsers();
    }

    @PutMapping("/approve/{id}")
    public String approveUser(
            @PathVariable String id
    ) {

        return adminService.approveUser(id);
    }

    @PutMapping("/reject/{id}")
    public String rejectUser(
            @PathVariable String id
    ) {

        return adminService.rejectUser(id);
    }
}