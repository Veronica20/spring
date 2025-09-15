package com.example.springboot.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class SignupRequest {

    @NotBlank(message = "FirstName cannot be empty")
    @Size(min = 2, max = 50, message = "FirstName must be between 2 and 50 characters")
    private String firstName;

    @NotBlank(message = "LastName cannot be empty")
    @Size(min = 2, max = 50, message = "LastName must be between 2 and 50 characters")
    private String lastName;

    @NotBlank(message = "Email cannot be empty")
    @Email(message = "Email should be valid")
    private String email;

    @NotBlank(message = "Password cannot be empty")
    @Size(min = 8, message = "Password must be at least 8 characters long")
    @Pattern(
            regexp = ".*[A-Z].*",
            message = "Password must contain at least one uppercase letter"
    )
    @Pattern(
            regexp = ".*[a-z].*",
            message = "Password must contain at least one lowercase letter"
    )
    @Pattern(
            regexp = ".*\\d.*",
            message = "Password must contain at least one number"
    )
    @Pattern(
            regexp = ".*[!@#$%^&*(),.?\":{}|<>].*",
            message = "Password must contain at least one special character"
    )
    private String password;

    // getters & setters
}

