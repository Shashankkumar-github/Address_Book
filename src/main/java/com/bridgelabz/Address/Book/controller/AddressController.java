package com.bridgelabz.Address.Book.controller;

import com.bridgelabz.Address.Book.dto.AddressDTO;
import com.bridgelabz.Address.Book.model.Address;
import com.bridgelabz.Address.Book.service.AddressService;
import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/addresses")
public class AddressController {
    @Autowired
    private  AddressService service;

    @GetMapping
    public ResponseEntity<List<AddressDTO>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<AddressDTO> getById(@PathVariable Long id) {
        AddressDTO address = service.getById(id);
        return address != null ? ResponseEntity.ok(address) : ResponseEntity.notFound().build();
    }
    @PostMapping
    public ResponseEntity<AddressDTO> add(@RequestBody AddressDTO addressDTO) {
        return ResponseEntity.ok(service.save(addressDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<AddressDTO> update(@PathVariable Long id, @RequestBody AddressDTO addressDTO) {
        addressDTO.setId(id);
        return ResponseEntity.ok(service.save(addressDTO));
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
