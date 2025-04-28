package com.example.demoIdentity.infrastructure.entrypoints.auth;

import com.example.demoIdentity.application.service.CustomerAuthService;
import com.example.demoIdentity.domain.model.response.LoginResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final CustomerAuthService authService;

    @PostMapping("/login")
    public LoginResponseDTO login(@RequestParam String email, @RequestParam String password) {
        return authService.login(email, password);
    }
}
