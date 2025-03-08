package com.bridgelabz.Address.Book.model;

import com.bridgelabz.Address.Book.dto.AddressDTO;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String phone;
    private String email;
    private String city;
    public Address(AddressDTO addressDTO) {
        this.name = addressDTO.getName();
        this.phone = addressDTO.getPhone();

    }
}
