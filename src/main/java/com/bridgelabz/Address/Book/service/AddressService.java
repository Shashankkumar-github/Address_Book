package com.bridgelabz.Address.Book.service;

import com.bridgelabz.Address.Book.dto.AddressDTO;
import com.bridgelabz.Address.Book.model.Address;
import com.bridgelabz.Address.Book.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
@Slf4j
@Service
public class AddressService {
    @Autowired
    private  AddressRepository repository;

    private final List<Address> BookData = new ArrayList<>();

    public List<AddressDTO> getAll() {  return repository.findAll().stream()
            .map(this::convertToDTO)
            .collect(Collectors.toList()); }

    public AddressDTO getById(Long id) { return repository.findById(id).map(this::convertToDTO).orElse(null); }

    public AddressDTO save(AddressDTO addressDTO) {   Address address = convertToEntity(addressDTO);
        return convertToDTO(repository.save(address)); }

    public void delete(Long id) { repository.deleteById(id); }
    private AddressDTO convertToDTO(Address address) {
        return new AddressDTO(address.getId(), address.getName(), address.getPhone());
    }

    private Address convertToEntity(AddressDTO dto) {
        return new Address(dto.getId(), dto.getName(), dto.getPhone(), null, null);
    }
    public void addBookRecord(Address record) {
        BookData.add(record);
        log.info("Added Book Record: {}", record);
    }

    public List<Address> getAllBookRecords() {
        log.info("Fetching all payroll records. Total: {}", BookData.size());
        return new ArrayList<>(BookData);
    }
}

