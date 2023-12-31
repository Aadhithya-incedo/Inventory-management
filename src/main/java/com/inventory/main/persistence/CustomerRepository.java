package com.inventory.main.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import com.inventory.main.models.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer>{

}
