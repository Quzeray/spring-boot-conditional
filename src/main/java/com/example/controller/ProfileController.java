package com.example.controller;

import com.example.profile.SystemProfile;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class ProfileController {
    private final SystemProfile profile;

    public ProfileController(SystemProfile profile) {
        this.profile = profile;
    }

    @GetMapping
    public ResponseEntity<String> getStatus() {
        return ResponseEntity.ok(profile.getProfile());
    }

    @GetMapping("profile")
    public String getProfile() {
        return profile.getProfile();
    }
}