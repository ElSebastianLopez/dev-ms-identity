package com.example.demoIdentity.domain.model.response;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class LoginResponseDTO {
    private String fullName;
    private String nit;
    private String token;
    private long expirationTimestamp;
    private String email;
}
