package com.inventory.main.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import com.inventory.main.models.InwardRegister;

public interface InwardRepository extends JpaRepository<InwardRegister, Integer>{

}
