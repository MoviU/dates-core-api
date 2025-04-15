package com.dates.core_api.model.dto;

import com.dates.core_api.validator.annotation.AtLeastOnePresent;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@AtLeastOnePresent(fields = {"email", "phoneNumber"})
public record RegisterUserRequestDto (
        @Email(message = "Invalid email format")
        String email,
        @Pattern(regexp = "^\\+?[1-9][0-9]{7,14}$", message = "Invalid phone number")
        String phoneNumber,
        @NotBlank(message = "Password is required")
        @Size(min = 8, max = 64, message = "Password must be between 8 and 64 characters")
        String password
) {
}
