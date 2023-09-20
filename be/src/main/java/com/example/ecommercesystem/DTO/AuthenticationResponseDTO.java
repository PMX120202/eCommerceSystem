package com.example.ecommercesystem.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthenticationResponseDTO extends ResponseClient{
    private String email;
    private String firstName;
    private String lastName;
    private String telephone;
    private String avatar;
    private String token;
}
