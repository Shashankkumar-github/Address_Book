package com.bridgelabz.Address.Book.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.bridgelabz.Address.Book.model.Address;

public interface AddressRepository extends JpaRepository<Address, Long> {
}

