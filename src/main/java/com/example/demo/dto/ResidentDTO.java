package com.example.demo.dto;

import com.example.demo.validation.ApartmentExists;
import com.example.demo.validation.ValidPassword;
import jakarta.validation.constraints.*;
import lombok.*;

import java.util.Set;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ResidentDTO {
    private String fullName;
    private Long age;
    private String phone;

    @Pattern(regexp = "^(ADMIN|USER)$", message = "Role must be ADMIN or USER")
    private String role;

    @ApartmentExists(message = "Apartment không tồn tại trong hệ thống")
    private Set<String> apartmentNumbers;
}
