package com.bridgelabz.Address.Book.service;

import com.bridgelabz.Address.Book.model.Address;
import com.bridgelabz.Address.Book.repository.AddressRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressService {
    private final AddressRepository repository;

    public AddressService(AddressRepository repository) {
        this.repository = repository;
    }

    public List<Address> getAll() { return repository.findAll(); }

    public Address getById(Long id) { return repository.findById(id).orElse(null); }

    public Address save(Address address) { return repository.save(address); }

    public void delete(Long id) { repository.deleteById(id); }
}

