package com.bridgelabz.Address.Book.dto;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddressDTO {
    private Long id;
    @NotBlank(message = "Name cannot be empty")
    @Pattern(regexp = "^[A-Za-z ]{3,50}$", message = "Name must contain only letters and spaces (3-50 characters)")
    private String name;
    private String phone;
}
