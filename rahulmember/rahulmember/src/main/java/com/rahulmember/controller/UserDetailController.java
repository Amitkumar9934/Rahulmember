package com.rahulmember.controller;

import com.rahulmember.entity.UserDetail;
import com.rahulmember.service.UserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserDetailController {

    @Autowired
    private UserDetailService userDetailService;

    @PostMapping("/create")
    public ResponseEntity<String> createUser(@RequestBody UserDetail userDetail) {
        try {
            userDetailService.createUser(userDetail);
            return ResponseEntity.ok("User created successfully.");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
