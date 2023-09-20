package com.example.ecommercesystem.DTO;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthenticationRequestDTO {
    @NotEmpty(message = "Email cannot be null")
    @Email(message = "Email should be valid")
    private String email;

    @NotEmpty(message = "Password cannot be null")
    @Size(min = 6, message = "Password must be more length than 6 character")
    private String password;
}
