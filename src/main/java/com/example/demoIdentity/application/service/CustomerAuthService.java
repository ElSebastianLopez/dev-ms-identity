package com.example.demoIdentity.application.service;

import com.example.demoIdentity.application.mapper.login.LoginMapper;
import com.example.demoIdentity.domain.exception.InvalidCredentialsException;
import com.example.demoIdentity.domain.exception.UserNotFoundException;
import com.example.demoIdentity.domain.model.response.LoginResponseDTO;
import com.example.demoIdentity.domain.port.in.CustomerAuthUseCase;
import com.example.demoIdentity.infrastructure.config.security.JwtProvider;
import com.example.demoIdentity.infrastructure.drivenadapters.customer.CustomerData;
import com.example.demoIdentity.infrastructure.drivenadapters.customer.gateway.CustomerGateway;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class CustomerAuthService implements CustomerAuthUseCase {

    private final CustomerGateway repository;
    private final PasswordEncoder passwordEncoder;
    private final JwtProvider jwtProvider;
    private final LoginMapper customerMapper;

    public CustomerAuthService(JwtProvider jwtProvider,PasswordEncoder passwordEncoder, CustomerGateway repository,LoginMapper customerMapper){
        this.jwtProvider = jwtProvider;
        this.passwordEncoder = passwordEncoder;
        this.repository = repository;
        this.customerMapper = customerMapper;
    }

    @Override
    public LoginResponseDTO login(String email, String password) {
        CustomerData customer = repository.findByEmail(email)
                .orElseThrow(() -> new UserNotFoundException("Usuario no encontrado"));

        if (!passwordEncoder.matches(password, customer.getPassword())) {
            throw new InvalidCredentialsException("Credenciales inválidas");
        }
        String token = jwtProvider.generateToken(email);

        long expirationTimeMillis = System.currentTimeMillis() + jwtProvider.getExpiration();

        return customerMapper.toLoginResponseDTO(customer, token, expirationTimeMillis);
    }
}
