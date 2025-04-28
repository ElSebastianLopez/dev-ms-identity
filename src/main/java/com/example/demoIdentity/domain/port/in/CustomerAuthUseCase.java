package com.example.demoIdentity.domain.port.in;

import com.example.demoIdentity.domain.model.response.LoginResponseDTO;
import com.example.demoIdentity.infrastructure.drivenadapters.customer.CustomerData;

public interface CustomerAuthUseCase {


    LoginResponseDTO login(String email, String password);
//    CustomerData register(CustomerData customer);
}
