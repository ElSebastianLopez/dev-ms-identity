package com.example.demoIdentity.infrastructure.drivenadapters.customer.repository;

import com.example.demoIdentity.infrastructure.drivenadapters.customer.CustomerData;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CustomerRepository extends JpaRepository<CustomerData, Long> {
    Optional<CustomerData> findByEmail(String email);
}
