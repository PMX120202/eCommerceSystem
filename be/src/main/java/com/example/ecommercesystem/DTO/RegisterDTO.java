package com.example.ecommercesystem.DTO;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegisterDTO {
    @NotEmpty(message = "Email cannot be null")
    @Email(message = "Email should be valid")
    private String email;

    @NotEmpty(message = "Password cannot be null")
    @Size(min = 6, message = "Password must be more length than 6 character")
    @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-zA-Z])(?=.*[@#$%^&+=])(?=\\S+$).{6,}$", message = "Password contain characters and at least a special character and 1 digit")
    private String password;

    @NotEmpty(message = "Confirm password cannot be null")
    @Size(min = 6, message = "Confirm password must be more length than 6 character")
    private String confirmPassword;

    @NotEmpty(message = "First name cannot be null")
    private String firstName;

    @NotEmpty(message = "Last name cannot be null")
    private String lastName;

    private String telephone;
}
