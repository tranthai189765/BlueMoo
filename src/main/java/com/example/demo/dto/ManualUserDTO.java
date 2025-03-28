package com.example.demo.dto;

import com.example.demo.validation.ApartmentExists;
import com.example.demo.validation.UniqueEmail;
import com.example.demo.validation.UniqueName;
import com.example.demo.validation.ValidPassword;
import jakarta.validation.constraints.*;
import lombok.*;

import java.util.List;
import java.util.Set;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ManualUserDTO {
    @NotBlank(message = "Name is required")
    @UniqueName(message = "Name already exists")
    private String name;

    @Size(min = 8, message = "Password must be at least 8 characters")
    @ValidPassword
    private String password;

    @Pattern(regexp = "^(ADMIN|USER)$", message = "Role must be ADMIN or USER")
    private String role;

    private String fullName;
    private Long age;
    private String phone;

    @Email(message = "Email should be valid")
    @UniqueEmail(message = "Email already exists")
    private String email;

    @ApartmentExists(message = "Apartment không tồn tại trong hệ thống")
    private Set<String> apartmentNumbers;
}