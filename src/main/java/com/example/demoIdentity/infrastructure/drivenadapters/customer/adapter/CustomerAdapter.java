package com.example.demoIdentity.infrastructure.drivenadapters.customer.adapter;

import com.example.demoIdentity.infrastructure.drivenadapters.customer.CustomerData;
import com.example.demoIdentity.infrastructure.drivenadapters.customer.gateway.CustomerGateway;
import com.example.demoIdentity.infrastructure.drivenadapters.customer.repository.CustomerRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class CustomerAdapter implements CustomerGateway {
    private final CustomerRepository customerRepository;

    public CustomerAdapter(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public Optional<CustomerData> findByEmail (String email){
        return  customerRepository.findByEmail(email);
    }
}
