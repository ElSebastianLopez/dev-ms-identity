package com.example.demoIdentity.infrastructure.drivenadapters.customer;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(
        name = "customers",
        schema = "dbo",
        uniqueConstraints = {
                @UniqueConstraint(name = "uk_customer_email", columnNames = "email"),
                @UniqueConstraint(name = "uk_customer_nit", columnNames = "nit")
        }
)

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerData {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        @Column(name = "full_name", nullable = false)
        private String fullName;
        @Column(nullable = false, unique = true)
        private String nit;
        @Column(name = "cell_phone")
        private String cellPhone;
        @Column(nullable = false, unique = true)
        private String email;
        @Column(nullable = false)
        private String password;

}
