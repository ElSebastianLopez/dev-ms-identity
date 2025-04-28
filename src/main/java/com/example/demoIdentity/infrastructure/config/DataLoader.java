package com.example.demoIdentity.infrastructure.config;

import com.example.demoIdentity.infrastructure.drivenadapters.customer.CustomerData;
import com.example.demoIdentity.infrastructure.drivenadapters.customer.repository.CustomerRepository;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class DataLoader {

    @Bean
    public ApplicationRunner initializeData(CustomerRepository customerRepository, PasswordEncoder passwordEncoder) {
        return args -> {
            // Verificar si el usuario ya existe
            if (customerRepository.findByEmail("juan.perez@example.com").isEmpty()) {
                CustomerData defaultUser = new CustomerData();
                defaultUser.setFullName("Juan Pérez");
                defaultUser.setNit("1234567890");
                defaultUser.setCellPhone("1234567890");
                defaultUser.setEmail("juan.perez@example.com");
                defaultUser.setPassword(passwordEncoder.encode("123456!")); // Encriptar la contraseña

                // Guardar el usuario en la base de datos
                customerRepository.save(defaultUser);
                System.out.println("Usuario base creado: juan.perez@example.com");
            } else {
                System.out.println("El usuario base ya existe.");
            }
        };
    }
}
