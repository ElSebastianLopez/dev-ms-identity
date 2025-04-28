package com.example.demoIdentity.infrastructure.drivenadapters.customer.gateway;

import com.example.demoIdentity.infrastructure.drivenadapters.customer.CustomerData;
import org.springframework.stereotype.Service;

import java.util.Optional;

public interface CustomerGateway {

  Optional<CustomerData> findByEmail (String email);
}
