package com.inventory.main.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import com.inventory.main.models.Supplier;

public interface SupplierRepository extends JpaRepository<Supplier, Integer>{

}
