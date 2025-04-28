package com.example.demoIdentity.application.mapper.login;

import com.example.demoIdentity.domain.model.response.LoginResponseDTO;
import com.example.demoIdentity.infrastructure.drivenadapters.customer.CustomerData;
import org.springframework.stereotype.Component;

import java.time.Instant;

@Component
public class LoginMapper {
    public LoginResponseDTO toLoginResponseDTO(CustomerData customer, String token, long expirationTimeMillis) {
        LoginResponseDTO loginResponseDTO = new LoginResponseDTO();
        loginResponseDTO.setToken(token);
        loginResponseDTO.setFullName(customer.getFullName());
        loginResponseDTO.setNit(customer.getNit());
        loginResponseDTO.setExpirationTimestamp( Instant.ofEpochMilli(expirationTimeMillis).getEpochSecond());
        loginResponseDTO.setEmail(customer.getEmail());
        return loginResponseDTO;
    }
}
