package com.bridgelabz.Address.Book.controller;

import com.bridgelabz.Address.Book.dto.AddressDTO;
import com.bridgelabz.Address.Book.model.Address;
import com.bridgelabz.Address.Book.service.AddressService;
import org.springframework.http.ResponseEntity;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Slf4j
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
    public ResponseEntity<AddressDTO> add(@Valid @RequestBody AddressDTO addressDTO) {
        return ResponseEntity.ok(service.save(addressDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<AddressDTO> update(@PathVariable Long id,@Valid @RequestBody AddressDTO addressDTO) {
        addressDTO.setId(id);
        return ResponseEntity.ok(service.save(addressDTO));
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
    // logger
    @PostMapping("/book/add")
    public String addBook(@RequestBody Address record) {
        service.addBookRecord(record);
        log.info("Received request to add book record: {}", record);
        return "Book record added successfully!";
    }

    @GetMapping("/book/all")
    public List<Address> getAllAddress() {
        log.info("Received request to fetch all book records.");
        return service.getAllBookRecords();
    }

}
